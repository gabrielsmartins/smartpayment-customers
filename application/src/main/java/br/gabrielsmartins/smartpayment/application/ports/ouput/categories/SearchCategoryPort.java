package br.gabrielsmartins.smartpayment.application.ports.ouput.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;

import java.util.List;
import java.util.Optional;

public interface SearchCategoryPort {

    Optional<Category> findById(String id);
    List<Category> findAll();

}
