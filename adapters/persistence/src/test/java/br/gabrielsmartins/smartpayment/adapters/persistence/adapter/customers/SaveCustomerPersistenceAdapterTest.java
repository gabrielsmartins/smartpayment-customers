package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapperImpl;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.customers.SaveCustomerPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveCustomerPersistenceAdapterTest {

    private SaveCustomerPersistenceAdapter adapter;
    private SaveCustomerPersistenceService service;
    private CustomerPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.service = mock(SaveCustomerPersistenceService.class);
        this.mapper = new CustomerPersistenceMapperImpl();
        this.adapter = new SaveCustomerPersistenceAdapter(service, mapper);
    }

    @Test
    @DisplayName("Given Customer When Save Then Return Saved Customer")
    public void givenCustomerWhenSaveThenReturnSavedCustomer(){

        Category category = Category.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        Customer customer = Customer.builder()
                .withId(UUID.randomUUID().toString())
                .withCategory(category)
                .withName("Foo")
                .withDocumentNumber("00000001000101")
                .withDocumentType(DocumentType.CNPJ)
                .build();

        when(service.save(any(CustomerEntity.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Customer savedCustomer = this.adapter.save(customer);

        assertThat(savedCustomer).isNotNull();
    }

}
