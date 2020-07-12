package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCustomerPersistenceService implements ISaveCustomerPersistenceService {

    private final CustomerRepository repository;

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return repository.save(customerEntity);
    }
}
