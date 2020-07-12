package br.gabrielsmartins.smartpayment.adapters.web.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO.CustomerDTOBuilder;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer.CustomerBuilder;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-12T18:20:28-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.7 (Ubuntu)"
)
@Component
public class CustomerWebMapperImpl implements CustomerWebMapper {

    @Override
    public Customer mapToDomain(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.id( customerDTO.getId() );
        customer.name( customerDTO.getName() );
        if ( customerDTO.getDocumentType() != null ) {
            customer.documentType( Enum.valueOf( DocumentType.class, customerDTO.getDocumentType() ) );
        }
        customer.documentNumber( customerDTO.getDocumentNumber() );

        return customer.build();
    }

    @Override
    public CustomerDTO mapToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        if ( customer.getDocumentType() != null ) {
            customerDTO.documentType( customer.getDocumentType().name() );
        }
        customerDTO.documentNumber( customer.getDocumentNumber() );

        return customerDTO.build();
    }
}
