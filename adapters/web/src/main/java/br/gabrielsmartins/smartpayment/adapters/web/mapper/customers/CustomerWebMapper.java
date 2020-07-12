package br.gabrielsmartins.smartpayment.adapters.web.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerWebMapper {

    Customer mapToDomain(CustomerDTO customerDTO);

    CustomerDTO mapToDto(Customer customer);

}
