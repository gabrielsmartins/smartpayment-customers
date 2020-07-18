package br.gabrielsmartins.smartpayment.adapters.web.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryWebMapperTest {

    private CategoryWebMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new CategoryWebMapperImpl();
    }

    @Test
    @DisplayName("Given Category Domain When Map Then Return Category DTO")
    public void givenCategoryDomainWhenMapThenReturnCategoryDTO(){
        Category category = Category.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        CategoryDTO categoryDTO = this.mapper.mapToDTO(category);

        assertThat(categoryDTO.getId()).isEqualTo(category.getId());
        assertThat(categoryDTO.getDescription()).isEqualTo(category.getDescription());
    }

    @Test
    @DisplayName("Given Category DTO When Map Then Return Category Domain")
    public void givenCategoryDTOWhenMapThenReturnCategoryDomain(){
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        Category category = this.mapper.mapToDomain(categoryDTO);

        assertThat(category.getId()).isEqualTo(categoryDTO.getId());
        assertThat(category.getDescription()).isEqualTo(categoryDTO.getDescription());
    }
}
