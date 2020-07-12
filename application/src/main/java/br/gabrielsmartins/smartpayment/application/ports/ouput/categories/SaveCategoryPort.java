package br.gabrielsmartins.smartpayment.application.ports.ouput.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;

public interface SaveCategoryPort {
    Category save(Category category);
}
