package br.gabrielsmartins.smartpayment.application.service.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SearchCategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchCategoryServiceTest {

    private SearchCategoryService service;
    private SearchCategoryPort port;

    @BeforeEach
    public void setup() {
        this.port = mock(SearchCategoryPort.class);
        this.service = new SearchCategoryService(port);
    }

    @Test
    @DisplayName("Given Category Id When Search Then Return Category")
    public void givenCategoryIdWhenSearchThenReturnCategory() {
        when(port.findById(anyString())).thenReturn(Optional.ofNullable(Category.builder()
                .withId(UUID.randomUUID().toString())
                .withDescription("GOLD")
                .build()));
        Optional<Category> optionalCategory = this.service.findById(UUID.randomUUID().toString());
        assertFalse(optionalCategory.isEmpty());
    }

    @Test
    @DisplayName("Given Categories When Search Then Return Categories List")
    public void givenCategoriesWhenSearchThenReturnCategoriesList() {
        when(port.findAll()).thenReturn(Arrays.asList(Category.builder()
                                        .withId(UUID.randomUUID().toString())
                                        .withDescription("GOLD")
                                        .build()));
        List<Category> categories = this.service.findAll();
        assertFalse(categories.isEmpty());
    }
}
