package br.gabrielsmartins.smartpayment.application.ports.input.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;

public interface SaveCustomerUseCase {

    Customer save(Customer customer);

}
