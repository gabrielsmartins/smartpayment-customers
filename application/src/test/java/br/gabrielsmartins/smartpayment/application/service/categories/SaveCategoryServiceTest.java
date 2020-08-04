package br.gabrielsmartins.smartpayment.application.service.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SaveCategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveCategoryServiceTest {


    private SaveCategoryService service;
    private SaveCategoryPort port;

    @BeforeEach
    public void setup(){
      this.port = mock(SaveCategoryPort.class);
      this.service = new SaveCategoryService(port);
    }


    @Test
    @DisplayName("Given Category When Save Then Return Saved Category")
    public void givenCategoryWhenSaveThenReturnSavedCategory(){

        when(port.save(any(Category.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Category category = Category.builder()
                                    .withId(UUID.randomUUID().toString())
                                    .withDescription("GOLD")
                                    .build();

        Category savedCategory = this.service.save(category);
        assertThat(savedCategory).isNotNull();
    }
}
