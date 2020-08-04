package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerPersistenceMapperTest {

    private CustomerPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new CustomerPersistenceMapperImpl();
    }

    @Test
    @DisplayName("Given Customer Entity When Map Then Return Customer Domain")
    public void givenCustomerEntityWhenMapThenReturnCustomerDomain(){

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

        Customer customer = this.mapper.mapToDomain(customerEntity);

        assertThat(customer.getId()).isEqualTo(customerEntity.getId());
        assertThat(customer.getName()).isEqualTo(customerEntity.getName());
        assertThat(customer.getDocumentNumber()).isEqualTo(customerEntity.getDocumentNumber());
        assertThat(customer.getDocumentType()).isEqualTo(customerEntity.getDocumentType());
        assertThat(customer.getCategory()).isNotNull();
    }


    @Test
    @DisplayName("Given Customer Domain When Map Then Return Customer Entity")
    public void givenCustomerDomainWhenMapThenReturnCustomerEntity(){

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

        CustomerEntity customerEntity = this.mapper.mapToEntity(customer);

        assertThat(customerEntity.getId()).isEqualTo(customer.getId());
        assertThat(customerEntity.getName()).isEqualTo(customer.getName());
        assertThat(customerEntity.getDocumentNumber()).isEqualTo(customer.getDocumentNumber());
        assertThat(customerEntity.getDocumentType()).isEqualTo(customer.getDocumentType());
        assertThat(customerEntity.getCategory()).isNotNull();
    }


}
