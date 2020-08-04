package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapperImpl;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.categories.SearchCategoryPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchCategoryPersistenceAdapterTest {

    private SearchCategoryPersistenceAdapter adapter;
    private SearchCategoryPersistenceService service;
    private CategoryPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.service = mock(SearchCategoryPersistenceService.class);
        this.mapper = new CategoryPersistenceMapperImpl();
        this.adapter = new SearchCategoryPersistenceAdapter(service, mapper);
    }

    @Test
    @DisplayName("Given Category Id When Exists Then Return Category")
    public void givenCategoryIdWhenExistsThenReturnCategory(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                                    .withId(UUID.randomUUID().toString())
                                    .withDescription("GOLD")
                                    .build();

        when(service.findById(anyString())).thenReturn(Optional.ofNullable(categoryEntity));

        Optional<Category> optionalCategory = this.adapter.findById(UUID.randomUUID().toString());
        assertTrue(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Categories When Exists Then Return Category List")
    public void givenCategoriesWhenExistsThenReturnCategoryList(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        when(service.findAll()).thenReturn(Arrays.asList(categoryEntity));

        List<Category> categories = this.adapter.findAll();
        assertFalse(categories.isEmpty());
    }
}
