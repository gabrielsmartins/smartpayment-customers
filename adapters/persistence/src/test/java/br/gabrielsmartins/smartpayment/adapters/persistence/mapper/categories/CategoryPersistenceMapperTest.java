package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryPersistenceMapperTest {

    private CategoryPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new CategoryPersistenceMapperImpl();
    }

    @Test
    @DisplayName("Given Category Entity When Map Then Return Category Domain")
    public void givenCategoryEntityWhenMapThenReturnCategoryDomain(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                                            .withId(UUID.randomUUID().toString())
                                            .withDescription("GOLD")
                                           .build();

        Category category = this.mapper.mapToDomain(categoryEntity);

        assertThat(category.getId()).isEqualTo(categoryEntity.getId());
        assertThat(category.getDescription()).isEqualTo(categoryEntity.getDescription());
    }


    @Test
    @DisplayName("Given Category Domain When Map Then Return Category Entity")
    public void givenCategoryDomainWhenMapThenReturnCategoryEntity(){

        Category category = Category.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        CategoryEntity categoryEntity = this.mapper.mapToEntity(category);

        assertThat(categoryEntity.getId()).isEqualTo(category.getId());
        assertThat(categoryEntity.getDescription()).isEqualTo(category.getDescription());
    }
}
