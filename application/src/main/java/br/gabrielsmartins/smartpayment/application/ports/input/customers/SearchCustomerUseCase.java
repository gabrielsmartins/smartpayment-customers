package br.gabrielsmartins.smartpayment.application.ports.input.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;

import java.util.List;
import java.util.Optional;

public interface SearchCustomerUseCase {
    Optional<Customer> findById(String id);
    List<Customer> findAll();
}
