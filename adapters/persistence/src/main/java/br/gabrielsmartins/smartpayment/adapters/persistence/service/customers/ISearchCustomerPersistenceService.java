package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface ISearchCustomerPersistenceService {
    Optional<CustomerEntity> findById(String id);
    List<CustomerEntity> findAll();
}
