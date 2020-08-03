package br.gabrielsmartins.smartpayment.adapters.web.adapter.in.customers;


import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapper;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SaveCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class SaveCustomerController {

    private SaveCustomerUseCase useCase;
    private CustomerWebMapper mapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestHeader HttpHeaders httpHeaders, @RequestBody CustomerDTO customerDTORequest){
        Customer customer = mapper.mapToDomain(customerDTORequest);
        Customer savedCustomer = useCase.save(customer);
        CustomerDTO savedCustomerResponseDTO = mapper.mapToDto(savedCustomer);
        URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(savedCustomerResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(savedCustomerResponseDTO);
    }


}
