package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.springframework.stereotype.Component;

@Mapper//(componentModel="spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
