package br.gabrielsmartins.smartpayment.adapters.web.controller.customers;

import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapper;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapperImpl;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.customers.Customer;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SearchCustomerUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SearchCustomerController.class)
@Import(CustomerWebMapperImpl.class)
public class SearchCustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchCustomerUseCase useCase;

    @SpyBean
    private CustomerWebMapper mapper;
    
    private ObjectMapper objectMapper;
    
    @BeforeEach
    public void setup(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Given Customers When Exists Then Return Customer List")
    public void givenCustomersWhenExistsThenReturnCustomerList() throws Exception {


        String customerId = UUID.randomUUID().toString();

        Category category = Category.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        Customer customer = Customer.builder()
                .withId(customerId)
                .withName("Foo")
                .withCategory(category)
                .withDocumentNumber("00000001000101")
                .withDocumentType(DocumentType.CNPJ)
                .build();

        when(useCase.findAll()).thenReturn(Arrays.asList(customer));


        MvcResult mvcResult = this.mockMvc.perform(get("/customers")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    @DisplayName("Given Customer Id When Exists Then Return Customer")
    public void givenCustomerIdWhenExistsThenReturnCustomer() throws Exception {


        String customerId = UUID.randomUUID().toString();

        Category category = Category.builder()
                                        .withId(UUID.randomUUID().toString())
                                        .withDescription("GOLD")
                                        .build();

        Customer customer = Customer.builder()
                                        .withId(customerId)
                                        .withName("Foo")
                                        .withCategory(category)
                                        .withDocumentNumber("00000001000101")
                                        .withDocumentType(DocumentType.CNPJ)
                                        .build();

        when(useCase.findById(anyString())).thenReturn(Optional.ofNullable(customer));


        MvcResult mvcResult = this.mockMvc.perform(get("/customers/" + customerId)
                .header("Accept", MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();
    }


    @Test
    @DisplayName("Given Customer Id When Not Exists Then Return Customer")
    public void givenCustomerIdWhenNotExistsThenReturnCustomer() throws Exception {


        String customerId = UUID.randomUUID().toString();



        MvcResult mvcResult = this.mockMvc.perform(get("/customers/" + customerId)
                .header("Accept", MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        assertThat(response.getContentAsString()).isEmpty();
    }
    

}
