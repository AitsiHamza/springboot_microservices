package com.example.ensetbillingservice.services;

import com.example.ensetbillingservice.dto.Customer;
import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Invoice;
import com.example.ensetbillingservice.exceptions.ClientCustomerNotFoundException;
import com.example.ensetbillingservice.mappers.InvoiceMapper;
import com.example.ensetbillingservice.openfeign.CustomerRestClient;
import com.example.ensetbillingservice.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    /*public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.customerRestClient = customerRestClient;
    }*/

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws ClientCustomerNotFoundException {
        Customer customer=customerRestClient.getCustomer(invoiceRequestDTO.getCustomerID());
        if(customer==null)throw new ClientCustomerNotFoundException("This customer "+invoiceRequestDTO.getCustomerID()+" doesn't exist!");
        Invoice invoice=invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice saveInvoice=invoiceRepository.save(invoice);
        saveInvoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice=invoiceRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String id) {
        List<Invoice> invoices=invoiceRepository.findByCustomerID(id);
        return invoices.stream().map(invoice -> {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
            return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
        }).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        invoices.forEach(invoice->{
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(invoice->invoiceMapper.invoiceToInvoiceResponseDTO(invoice)).collect(Collectors.toList());
    }
}
