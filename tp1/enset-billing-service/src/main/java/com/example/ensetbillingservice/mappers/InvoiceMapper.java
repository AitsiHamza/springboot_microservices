package com.example.ensetbillingservice.mappers;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.dto.InvoiceResponseDTO;
import com.example.ensetbillingservice.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/*@Mapper//(componentModel="spring")
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper( InvoiceMapper.class );
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}*/


@Component
public class InvoiceMapper{
    public InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice){
        InvoiceResponseDTO invoiceResponseDTO=new InvoiceResponseDTO();
        BeanUtils.copyProperties(invoice,invoiceResponseDTO);
        return invoiceResponseDTO;
    }
    public Invoice invoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO){
        Invoice invoice=new Invoice();
        BeanUtils.copyProperties(invoiceRequestDTO,invoice);
        return invoice;
    }
}
