package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapperImpl;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.categories.SaveCategoryPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveCategoryPersistenceAdapterTest {

    private SaveCategoryPersistenceAdapter adapter;
    private SaveCategoryPersistenceService service;
    private CategoryPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.service = mock(SaveCategoryPersistenceService.class);
        this.mapper = new CategoryPersistenceMapperImpl();
        this.adapter = new SaveCategoryPersistenceAdapter(service, mapper);
    }

    @Test
    @DisplayName("Given Category When Save Then Return Saved Category")
    public void givenCategoryWhenSaveThenReturnSavedCategory(){

        Category category = Category.builder()
                                    .withId(UUID.randomUUID().toString())
                                    .withDescription("GOLD")
                                    .build();

        when(service.save(any(CategoryEntity.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Category savedCategory = this.adapter.save(category);
        assertThat(savedCategory).isNotNull();
    }
}
