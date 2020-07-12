package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder(disableBuilder = true))
public interface CustomerPersistenceMapper {

    Customer mapToDomain(CustomerEntity customerEntity);
    List<Customer> mapToDomain(List<CustomerEntity> customerEntity);

    CustomerEntity mapToEntity(Customer customer);
    List<CustomerEntity> mapToEntity(List<Customer> customer);

}
