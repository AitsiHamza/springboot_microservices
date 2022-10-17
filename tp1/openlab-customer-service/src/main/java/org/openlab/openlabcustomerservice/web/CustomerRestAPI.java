package org.openlab.openlabcustomerservice.web;

import lombok.AllArgsConstructor;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api")
@AllArgsConstructor
public class CustomerRestAPI  {
    private CustomerService customerService;

    @GetMapping(path="/customers")
    public List<CustomerResponseDTO> customers(){
        return customerService.listCustomers();
    }

    @PostMapping(path="/customers")
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @PostMapping(path="/customers/{id}")
    public CustomerResponseDTO save(@PathVariable String id){
        return customerService.getCustomer(id);
    }

}
