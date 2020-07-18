package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories.CategoryRepository;
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


public class SearchCategoryPersistenceServiceTest {

    private SearchCategoryPersistenceService service;
    private CategoryRepository repository;

    @BeforeEach
    public void setup(){
        this.repository = mock(CategoryRepository.class);
        this.service = new SearchCategoryPersistenceService(repository);
    }

    @Test
    @DisplayName("Given Categories When Search Then Return Category LIst")
    public void givenCategoriesWhenSearchThenReturnCategoryList(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        when(repository.findAll()).thenReturn(Arrays.asList(categoryEntity));

        List<CategoryEntity> optionalCategoryEntity = service.findAll();
        assertFalse(optionalCategoryEntity.isEmpty());
    }

    @Test
    @DisplayName("Given Category Id When Search Then Return Category")
    public void givenCategoryIdWhenSearchThenReturnCategory(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(categoryEntity));

        Optional<CategoryEntity> optionalCategoryEntity = service.findById(UUID.randomUUID().toString());
        assertTrue(optionalCategoryEntity.isPresent());
    }





}
