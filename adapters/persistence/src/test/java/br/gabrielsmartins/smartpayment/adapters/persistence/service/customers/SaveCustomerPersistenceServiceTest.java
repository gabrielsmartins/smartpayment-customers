package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers.CustomerRepository;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SaveCustomerPersistenceServiceTest {

    private SaveCustomerPersistenceService service;
    private CustomerRepository repository;

    @BeforeEach
    public void setup(){
        this.repository = mock(CustomerRepository.class);
        this.service = new SaveCustomerPersistenceService(repository);
    }

    @Test
    @DisplayName("Given Customer When Save Then Return Saved Customer")
    public void givenCustomerWhenSaveThenReturnSavedCustomer(){


        CategoryEntity categoryEntity = CategoryEntity.builder()
                                                        .withId(UUID.randomUUID().toString())
                                                        .withDescription("GOLD")
                                                        .build();

        CustomerEntity customerEntity = CustomerEntity.builder()
                                                 .withId(UUID.randomUUID().toString())
                                                .withCategory(categoryEntity)
                                                .withName("Foo")
                                                .withDocumentNumber("00000001000101")
                                                .withDocumentType(DocumentType.CNPJ)
                                                .build();

        when(repository.save(customerEntity)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        CustomerEntity savedCustomer = service.save(customerEntity);

        assertThat(savedCustomer).isNotNull();
    }
}
