package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;

public interface ISaveCategoryPersistenceService {
    CategoryEntity save(CategoryEntity categoryEntity);
}
