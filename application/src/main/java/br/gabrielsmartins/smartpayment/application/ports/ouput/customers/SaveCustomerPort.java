package br.gabrielsmartins.smartpayment.application.ports.ouput.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;

public interface SaveCustomerPort {

    Customer save(Customer customer);

}
