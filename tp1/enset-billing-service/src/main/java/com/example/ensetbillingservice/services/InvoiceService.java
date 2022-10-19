package com.example.ensetbillingservice.services;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.exceptions.ClientCustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws ClientCustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String id);
    List<InvoiceResponseDTO> invoicesByCustomerId(String id);
    List<InvoiceResponseDTO> getAllInvoices();
}
