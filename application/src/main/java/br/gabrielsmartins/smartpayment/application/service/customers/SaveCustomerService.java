package br.gabrielsmartins.smartpayment.application.service.customers;

import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SaveCustomerUseCase;
import br.gabrielsmartins.smartpayment.application.ports.ouput.customers.SaveCustomerPort;
import br.gabrielsmartins.smartpayment.common.stereotype.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveCustomerService implements SaveCustomerUseCase {

    private final SaveCustomerPort port;

    @Override
    public Customer save(Customer customer) {
        return port.save(customer);
    }
}
