package br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

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

        CustomerEntity savedCustomer = repository.save(customerEntity);

        assertThat(savedCustomer).isNotNull();
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

        repository.save(customerEntity);

        List<CustomerEntity> customerEntities = repository.findAll();
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

        repository.save(customerEntity);

        Optional<CustomerEntity> optionalCustomerEntity = repository.findById(customerEntity.getId());
        assertTrue(optionalCustomerEntity.isPresent());
    }
}
