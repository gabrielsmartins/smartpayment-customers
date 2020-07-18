package br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PersistenceApplicationTest.class})
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    @DisplayName("Given Category When Save Then Return Saved Category")
    public void givenCategoryWhenSaveThenReturnSavedCategory(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        when(repository.save(categoryEntity)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        CategoryEntity savedCategory = repository.save(categoryEntity);

        assertThat(savedCategory).isNotNull();
    }

    @Test
    @DisplayName("Given Categories When Search Then Return Category LIst")
    public void givenCategoriesWhenSearchThenReturnCategoryList(){

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build();

        when(repository.findAll()).thenReturn(Arrays.asList(categoryEntity));

        List<CategoryEntity> optionalCategoryEntity = repository.findAll();
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

        Optional<CategoryEntity> optionalCategoryEntity = repository.findById(UUID.randomUUID().toString());
        assertTrue(optionalCategoryEntity.isPresent());
    }
}
