package br.gabrielsmartins.smartpayment.adapters.web.adapter.in.customers;

import br.gabrielsmartins.smartpayment.adapters.web.dto.customers.CustomerDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapper;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.customers.CustomerWebMapperImpl;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import br.gabrielsmartins.smartpayment.application.ports.input.customers.SaveCustomerUseCase;
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

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SaveCustomerController.class)
@Import(CustomerWebMapperImpl.class)
public class SaveCustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaveCustomerUseCase useCase;

    @SpyBean
    private CustomerWebMapper mapper;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Given Customer When Save Then Return Saved Customer")
    public void givenCustomerWhenSaveThenReturnSavedCustomer() throws Exception {

        CustomerDTO customerDTO = CustomerDTO.builder()
                                                .withId(UUID.randomUUID().toString())
                                                .withCategoryId(UUID.randomUUID().toString())
                                                .withName("Foo")
                                                .withDocumentNumber("00000001000101")
                                                .withDocumentType(DocumentType.CNPJ.name())
                                                .build();

        String content = objectMapper.writeValueAsString(customerDTO);

        MvcResult mvcResult = mockMvc.perform(post("/v1/customers")
                                     .header("Content-type", MediaType.APPLICATION_JSON)
                                     .header("Accept", MediaType.APPLICATION_JSON)
                                     .content(content))
                                     .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isNotNull();
    }

}
