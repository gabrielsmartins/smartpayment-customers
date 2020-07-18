package br.gabrielsmartins.smartpayment.adapters.persistence.service.customers;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers.CustomerEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchCustomerPersistenceService implements ISearchCustomerPersistenceService {

    private final CustomerRepository repository;

    @Override
    public Optional<CustomerEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return repository.findAll();
    }
}
