package br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataMongoTest
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

        repository.save(categoryEntity);

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

        repository.save(categoryEntity);

        Optional<CategoryEntity> optionalCategoryEntity = repository.findById(categoryEntity.getId());
        assertTrue(optionalCategoryEntity.isPresent());
    }
}
