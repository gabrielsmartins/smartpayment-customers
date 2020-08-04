package br.gabrielsmartins.smartpayment.adapters.web.mapper.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-04T08:20:01-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Ubuntu)"
)
@Component
public class CustomerWebMapperImpl implements CustomerWebMapper {

    @Override
    public Customer mapToDomain(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setName( customerDTO.getName() );
        if ( customerDTO.getDocumentType() != null ) {
            customer.setDocumentType( Enum.valueOf( DocumentType.class, customerDTO.getDocumentType() ) );
        }
        customer.setDocumentNumber( customerDTO.getDocumentNumber() );

        return customer;
    }

    @Override
    public List<Customer> mapToDomain(List<CustomerDTO> customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDTO.size() );
        for ( CustomerDTO customerDTO1 : customerDTO ) {
            list.add( mapToDomain( customerDTO1 ) );
        }

        return list;
    }

    @Override
    public CustomerDTO mapToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setName( customer.getName() );
        if ( customer.getDocumentType() != null ) {
            customerDTO.setDocumentType( customer.getDocumentType().name() );
        }
        customerDTO.setDocumentNumber( customer.getDocumentNumber() );

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> mapToDto(List<Customer> customer) {
        if ( customer == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customer.size() );
        for ( Customer customer1 : customer ) {
            list.add( mapToDto( customer1 ) );
        }

        return list;
    }
}
