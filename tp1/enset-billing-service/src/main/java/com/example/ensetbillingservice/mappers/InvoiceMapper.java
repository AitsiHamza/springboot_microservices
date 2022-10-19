package com.example.ensetbillingservice.mappers;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper//(componentModel="spring")
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper( InvoiceMapper.class );
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
