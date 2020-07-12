package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.categories.SaveCategoryPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SaveCategoryPort;
import br.gabrielsmartins.smartpayment.common.stereotype.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveCategoryPersistenceAdapter implements SaveCategoryPort {

    private final SaveCategoryPersistenceService service;
    private final CategoryPersistenceMapper mapper;


    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = mapper.mapToEntity(category);
        CategoryEntity savedCategoryEntity = service.save(categoryEntity);
        return mapper.mapToDomain(savedCategoryEntity);
    }
}
