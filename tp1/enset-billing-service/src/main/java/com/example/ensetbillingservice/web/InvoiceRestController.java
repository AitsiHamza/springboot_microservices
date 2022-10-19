package com.example.ensetbillingservice.web;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.exceptions.ClientCustomerNotFoundException;
import com.example.ensetbillingservice.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
@AllArgsConstructor
public class InvoiceRestController {
    private InvoiceService invoiceService;

    @GetMapping("/invoice/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name="id") String id){
        return invoiceService.getInvoice(id);
    }

    @GetMapping("/invoicesByCustomerId/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable(name="customerId") String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping("/invoice")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws ClientCustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping("/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.getAllInvoices();
    }

}
