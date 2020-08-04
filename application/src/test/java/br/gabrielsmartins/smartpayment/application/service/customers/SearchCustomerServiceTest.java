package br.gabrielsmartins.smartpayment.application.service.customers;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SearchCustomerPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchCustomerServiceTest {

    private SearchCustomerService service;
    private SearchCustomerPort port;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchCustomerPort.class);
        this.service = new SearchCustomerService(port);
    }

    @Test
    @DisplayName("Given Customer Id When Search Then Return Customer")
    public void givenCustomerIdWhenSearchThenReturnCustomer(){

        Customer customer = Customer.builder()
                .withId(UUID.randomUUID().toString())
                .withName("Stark Industries")
                .withDocumentType(DocumentType.CNPJ)
                .withCategory(Category.builder()
                        .withId(UUID.randomUUID().toString())
                        .withDescription("GOLD").build())
                .withDocumentNumber(String.valueOf(new Random().nextInt()))
                .build();

        when(port.findById(anyString())).thenReturn(Optional.ofNullable(customer));


        Optional<Customer> optionalCustomer = this.service.findById(UUID.randomUUID().toString());

        assertFalse(optionalCustomer.isEmpty());
    }


    @Test
    @DisplayName("Given Customers When Search Then Return Customers List")
    public void givenCustomersWhenSearchThenReturnCustomersList(){

        Customer customer = Customer.builder()
                .withId(UUID.randomUUID().toString())
                .withName("Stark Industries")
                .withDocumentType(DocumentType.CNPJ)
                .withCategory(Category.builder()
                        .withId(UUID.randomUUID().toString())
                        .withDescription("GOLD").build())
                .withDocumentNumber(String.valueOf(new Random().nextInt()))
                .build();

        when(port.findAll()).thenReturn(Arrays.asList(customer));


        List<Customer> customers = this.service.findAll();

        assertFalse(customers.isEmpty());
    }
}
