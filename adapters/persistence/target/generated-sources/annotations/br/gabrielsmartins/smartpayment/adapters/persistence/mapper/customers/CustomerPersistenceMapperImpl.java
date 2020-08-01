package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-01T18:07:01-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Ubuntu)"
)
@Component
public class CustomerPersistenceMapperImpl implements CustomerPersistenceMapper {

    @Override
    public Customer mapToDomain(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setName( customerEntity.getName() );
        customer.setDocumentType( customerEntity.getDocumentType() );
        customer.setDocumentNumber( customerEntity.getDocumentNumber() );
        customer.setCategory( categoryEntityToCategory( customerEntity.getCategory() ) );

        return customer;
    }

    @Override
    public List<Customer> mapToDomain(List<CustomerEntity> customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerEntity.size() );
        for ( CustomerEntity customerEntity1 : customerEntity ) {
            list.add( mapToDomain( customerEntity1 ) );
        }

        return list;
    }

    @Override
    public CustomerEntity mapToEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setName( customer.getName() );
        customerEntity.setDocumentType( customer.getDocumentType() );
        customerEntity.setDocumentNumber( customer.getDocumentNumber() );
        customerEntity.setCategory( categoryToCategoryEntity( customer.getCategory() ) );

        return customerEntity;
    }

    @Override
    public List<CustomerEntity> mapToEntity(List<Customer> customer) {
        if ( customer == null ) {
            return null;
        }

        List<CustomerEntity> list = new ArrayList<CustomerEntity>( customer.size() );
        for ( Customer customer1 : customer ) {
            list.add( mapToEntity( customer1 ) );
        }

        return list;
    }

    protected Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryEntity.getId() );
        category.setDescription( categoryEntity.getDescription() );

        return category;
    }

    protected CategoryEntity categoryToCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setDescription( category.getDescription() );

        return categoryEntity;
    }
}
