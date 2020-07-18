package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.customers;


import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapperImpl;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.customers.SearchCustomerPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
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

public class SearchCustomerPersistenceAdapterTest {

    private SearchCustomerPersistenceAdapter adapter;
    private SearchCustomerPersistenceService service;
    private CustomerPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.service = mock(SearchCustomerPersistenceService.class);
        this.mapper = new CustomerPersistenceMapperImpl();
        this.adapter = new SearchCustomerPersistenceAdapter(service, mapper);
    }

    @Test
    @DisplayName("Given Customer Id When Exists Then Return Customer")
    public void givenCustomerIdWhenExistsThenReturnCustomer(){

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

        when(service.findById(anyString())).thenReturn(Optional.ofNullable(customerEntity));

        Optional<Customer> optionalCustomer = this.adapter.findById(UUID.randomUUID().toString());
        assertTrue(optionalCustomer.isPresent());
    }

    @Test
    @DisplayName("Given Customers When Exists Then Return Customer List")
    public void givenCustomersWhenExistsThenReturnCustomerList(){

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

        when(service.findAll()).thenReturn(Arrays.asList(customerEntity));

        List<Customer> categories = this.adapter.findAll();
        assertFalse(categories.isEmpty());
    }
}
