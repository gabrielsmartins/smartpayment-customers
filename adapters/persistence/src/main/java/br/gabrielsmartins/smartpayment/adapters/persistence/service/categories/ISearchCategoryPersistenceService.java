package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface ISearchCategoryPersistenceService {
    Optional<CategoryEntity> findById(String id);
    List<CategoryEntity> findAll();
}
