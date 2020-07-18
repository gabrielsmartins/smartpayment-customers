package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;


import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers.CustomerRepository;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SearchCustomerPersistenceServiceTest {

    private SearchCustomerPersistenceService service;
    private CustomerRepository repository;

    @BeforeEach
    public void setup(){
        this.repository = mock(CustomerRepository.class);
        this.service = new SearchCustomerPersistenceService(repository);
    }
    
    @Test
    @DisplayName("Given Customers When Search Then Return Customer LIst")
    public void givenCustomersWhenSearchThenReturnCustomerList(){

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

        when(repository.findAll()).thenReturn(Arrays.asList(customerEntity));

        List<CustomerEntity> customerEntities = service.findAll();
        assertFalse(customerEntities.isEmpty());
    }

    @Test
    @DisplayName("Given Customer Id When Search Then Return Customer")
    public void givenCustomerIdWhenSearchThenReturnCustomer(){

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

        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(customerEntity));

        Optional<CustomerEntity> optionalCustomerEntity = service.findById(UUID.randomUUID().toString());
        assertTrue(optionalCustomerEntity.isPresent());
    }


}
