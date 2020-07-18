package br.gabrielsmartins.smartpayment.adapters.web.controller.categories;


import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapperImpl;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SaveCategoryUseCase;
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
@WebMvcTest(SaveCategoryController.class)
@Import(CategoryWebMapperImpl.class)
public class SaveCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaveCategoryUseCase useCase;

    @SpyBean
    private CategoryWebMapper mapper;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Given Category When Save Then Return Saved Category")
    public void givenCategoryWhenSaveThenReturnSavedCategory() throws Exception {

        CategoryDTO categoryDTO = CategoryDTO.builder()
                                            .withId(UUID.randomUUID().toString())
                                            .withDescription("GOLD")
                                            .build();

        String content = this.objectMapper.writeValueAsString(categoryDTO);

        MvcResult result = mockMvc.perform(post("/categories")
                                    .header("Content-type", MediaType.APPLICATION_JSON)
                                    .header("Accept", MediaType.APPLICATION_JSON)
                                    .content(content))
                                    .andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }


}
