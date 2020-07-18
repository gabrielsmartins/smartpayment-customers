package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.customers.SaveCustomerPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SaveCustomerPort;
import br.gabrielsmartins.smartpayment.common.stereotype.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveCustomerPersistenceAdapter implements SaveCustomerPort {

    private final SaveCustomerPersistenceService service;
    private final CustomerPersistenceMapper mapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = mapper.mapToEntity(customer);
        CustomerEntity savedCustomerEntity = service.save(customerEntity);
        return mapper.mapToDomain(savedCustomerEntity);
    }

}
