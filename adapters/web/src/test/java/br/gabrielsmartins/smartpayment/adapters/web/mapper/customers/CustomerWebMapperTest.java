package br.gabrielsmartins.smartpayment.adapters.web.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapperImpl;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerWebMapperTest {

    public CustomerWebMapper mapper;
    private CategoryWebMapper categoryWebMapper;

    @BeforeEach
    public void setup(){
        this.categoryWebMapper = new CategoryWebMapperImpl();
        this.mapper = new CustomerWebMapperImpl();
    }

    @Test
    @DisplayName("Given Customer Domain When Map Then Return Customer DTO")
    public void givenCustomerDomainWhenMapThenReturnCustomerDTO(){

        Customer customer = Customer.builder()
                .withId(UUID.randomUUID().toString())
                .withName("Stark Industries")
                .withDocumentType(DocumentType.CNPJ)
                .withCategory(Category.builder()
                        .withId(UUID.randomUUID().toString())
                        .withDescription("GOLD")
                        .build())
                .withDocumentNumber(String.valueOf(new Random().nextInt()))
                .build();

        CustomerDTO customerDTO = this.mapper.mapToDto(customer);

        assertThat(customerDTO.getId()).isEqualTo(customer.getId());
        assertThat(customerDTO.getName()).isEqualTo(customer.getName());
        assertThat(customerDTO.getDocumentType()).isEqualTo(customer.getDocumentType().toString());
        assertThat(customerDTO.getDocumentNumber()).isEqualTo(customer.getDocumentNumber());
    }



}
