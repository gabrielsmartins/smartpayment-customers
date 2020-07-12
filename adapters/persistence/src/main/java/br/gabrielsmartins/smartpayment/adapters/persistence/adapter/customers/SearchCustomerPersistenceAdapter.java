package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.customers.CustomerPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.customers.SearchCustomerPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SearchCustomerPort;
import br.gabrielsmartins.smartpayment.common.stereotype.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchCustomerPersistenceAdapter implements SearchCustomerPort {

    private final SearchCustomerPersistenceService service;
    private final CustomerPersistenceMapper mapper;

    @Override
    public Optional<Customer> findById(String id) {
        Optional<CustomerEntity> optionalCustomerEntity = service.findById(id);
        if (!optionalCustomerEntity.isEmpty())
            return Optional.ofNullable(mapper.mapToDomain(optionalCustomerEntity.get()));
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntities = service.findAll();
        return mapper.mapToDomain(customerEntities);
    }
}
