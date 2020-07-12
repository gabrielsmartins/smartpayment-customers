package br.gabrielsmartins.smartpayment.application.ports.ouput.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;

import java.util.List;
import java.util.Optional;

public interface SearchCustomerPort {

    Optional<Customer> findById(String id);
    List<Customer> findAll();

}
