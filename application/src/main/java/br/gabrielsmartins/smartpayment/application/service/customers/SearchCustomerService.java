package br.gabrielsmartins.smartpayment.application.service.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SearchCustomerUseCase;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SearchCustomerPort;
import br.gabrielsmartins.smartpayment.common.stereotype.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SearchCustomerService implements SearchCustomerUseCase {

    private final SearchCustomerPort port;

    @Override
    public Optional<Customer> findById(String id) {
        return port.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return port.findAll();
    }

}
