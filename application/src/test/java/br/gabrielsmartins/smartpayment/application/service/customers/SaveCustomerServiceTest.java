package br.gabrielsmartins.smartpayment.application.service.customers;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SaveCustomerPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveCustomerServiceTest {

    private SaveCustomerService service;
    private SaveCustomerPort port;

    @BeforeEach
    public void setup(){
        this.port = mock(SaveCustomerPort.class);
        this.service = new SaveCustomerService(port);
    }

    @Test
    @DisplayName("Given Customer When Save Then Return Saved Customer")
    public void givenCustomerWhenSaveThenReturnSavedCustomer(){

        Customer customer = Customer.builder()
                .withId(UUID.randomUUID().toString())
                .withName("Stark Industries")
                .withDocumentType(DocumentType.CNPJ)
                .withCategory(Category.builder()
                              .withId(UUID.randomUUID().toString())
                              .withDescription("GOLD").build())
                .withDocumentNumber(String.valueOf(new Random().nextInt()))
                .build();

        when(port.save(any(Customer.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Customer savedCustomer = this.service.save(customer);
        assertThat(savedCustomer).isNotNull();
    }
}
