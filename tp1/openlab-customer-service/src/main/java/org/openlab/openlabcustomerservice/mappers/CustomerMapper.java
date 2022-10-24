package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/*@Mapper//(componentModel="spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}*/

@Component
public class CustomerMapper{
    public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer){
        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        BeanUtils.copyProperties(customer,customerResponseDTO);
        return customerResponseDTO;
    }
    public Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerRequestDTO,customer);
        return customer;
    }
}
