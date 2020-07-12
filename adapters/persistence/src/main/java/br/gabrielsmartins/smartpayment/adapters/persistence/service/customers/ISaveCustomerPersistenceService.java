package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;

public interface ISaveCustomerPersistenceService {
    CustomerEntity save(CustomerEntity customerEntity);
}
