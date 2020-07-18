package br.gabrielsmartins.smartpayment.application.ports.input.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;

import java.util.List;
import java.util.Optional;

public interface SearchCategoryUseCase {
    Optional<Category> findById(String id);
    List<Category> findAll();
}
