package br.gabrielsmartins.smartpayment.adapters.web.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
uses = {CategoryWebMapper.class},
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
builder = @Builder(disableBuilder = true))
public interface CustomerWebMapper {

    Customer mapToDomain(CustomerDTO customerDTO);

    List<Customer> mapToDomain(List<CustomerDTO> customerDTO);

    CustomerDTO mapToDto(Customer customer);

    List<CustomerDTO> mapToDto(List<Customer> customer);

}
