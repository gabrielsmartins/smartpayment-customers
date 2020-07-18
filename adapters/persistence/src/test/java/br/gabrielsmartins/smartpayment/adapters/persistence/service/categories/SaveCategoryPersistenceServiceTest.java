package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SaveCategoryPersistenceServiceTest {

    private SaveCategoryPersistenceService service;
    private CategoryRepository repository;

    @BeforeEach
    public void setup(){
        this.repository = mock(CategoryRepository.class);
       this.service = new SaveCategoryPersistenceService(repository);
    }

    @Test
    @DisplayName("Given Category When Save Then Return Saved Category")
    public void givenCategoryWhenSaveThenReturnSavedCategory(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                                              .withId(UUID.randomUUID().toString())
                                              .withDescription("GOLD")
                                              .build();

        when(repository.save(categoryEntity)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        CategoryEntity savedCategory = service.save(categoryEntity);

        assertThat(savedCategory).isNotNull();
    }
}
