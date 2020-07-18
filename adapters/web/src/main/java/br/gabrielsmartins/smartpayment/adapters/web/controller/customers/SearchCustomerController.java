package br.gabrielsmartins.smartpayment.adapters.web.controller.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapper;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SearchCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class SearchCustomerController {

    private SearchCustomerUseCase useCase;
    private CustomerWebMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        Optional<Customer> optional = useCase.findById(id);
        if(optional.isPresent())
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Customer> customers = useCase.findAll();
        List<CustomerDTO> customerDTOS = mapper.mapToDto(customers);
        if(customerDTOS.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }
}
