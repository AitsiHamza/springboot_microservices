package com.example.ensetbillingservice;

import com.example.ensetbillingservice.dto.InvoiceRequestDTO;
import com.example.ensetbillingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class EnsetBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnsetBillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService){
        return args->{
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(75000),"111"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(715000),"112"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(5000),"112"));
        };
    }
}
