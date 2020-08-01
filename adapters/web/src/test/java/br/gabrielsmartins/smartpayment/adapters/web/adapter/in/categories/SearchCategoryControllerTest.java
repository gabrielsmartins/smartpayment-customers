package br.gabrielsmartins.smartpayment.adapters.web.adapter.in.categories;

import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapperImpl;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SearchCategoryUseCase;
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
@WebMvcTest(SearchCategoryController.class)
@Import(CategoryWebMapperImpl.class)
public class SearchCategoryControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchCategoryUseCase useCase;

    @SpyBean
    private CategoryWebMapper mapper;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Given Categories When Exists Then Return Category List")
    public void givenCategoriesWhenExistsThenReturnCategoryList() throws Exception {


        String categoryId = UUID.randomUUID().toString();

        Category category = Category.builder()
                .withId(categoryId)
                .withDescription("GOLD")
                .build();

        when(useCase.findAll()).thenReturn(Arrays.asList(category));


        MvcResult mvcResult = this.mockMvc.perform(get("/categories")
                .header("Accept", MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    @DisplayName("Given Category Id When Exists Then Return Category")
    public void givenCategoryIdWhenExistsThenReturnCategory() throws Exception {


        String categoryId = UUID.randomUUID().toString();

        Category category = Category.builder()
                                    .withId(categoryId)
                                    .withDescription("GOLD")
                                    .build();

        when(useCase.findById(anyString())).thenReturn(Optional.ofNullable(category));


        MvcResult mvcResult = this.mockMvc.perform(get("/categories/" + categoryId)
                                                    .header("Accept", MediaType.APPLICATION_JSON))
                                                    .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();
    }


    @Test
    @DisplayName("Given Category Id When Not Exists Then Return Category")
    public void givenCategoryIdWhenNotExistsThenReturnCategory() throws Exception {


        String categoryId = UUID.randomUUID().toString();



        MvcResult mvcResult = this.mockMvc.perform(get("/categories/" + categoryId)
                .header("Accept", MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        assertThat(response.getContentAsString()).isEmpty();
    }


}
