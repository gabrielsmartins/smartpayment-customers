package br.gabrielsmartins.smartpayment.application.ports.input.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;

public interface SaveCategoryUseCase {
    Category save(Category category);
}
