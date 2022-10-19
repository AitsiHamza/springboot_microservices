package com.example.ensetbillingservice.services;

import com.example.ensetbillingservice.dto.Customer;
import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Invoice;
import com.example.ensetbillingservice.mappers.InvoiceMapper;
import com.example.ensetbillingservice.openfeign.CustomerRestClient;
import com.example.ensetbillingservice.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        Invoice saveInvoice=invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice=invoiceRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String id) {
        List<Invoice> invoices=invoiceRepository.findByCustomerID(id);
        return invoices.stream().map(invoice->invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }
}
