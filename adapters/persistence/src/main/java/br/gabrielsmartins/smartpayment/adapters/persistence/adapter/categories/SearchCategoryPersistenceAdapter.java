package br.gabrielsmartins.smartpayment.adapters.persistence.adapter.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.gabrielsmartins.smartpayment.adapters.persistence.service.categories.SearchCategoryPersistenceService;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SearchCategoryPort;
import br.gabrielsmartins.smartpayment.common.stereotype.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchCategoryPersistenceAdapter implements SearchCategoryPort {

    private final SearchCategoryPersistenceService service;
    private final CategoryPersistenceMapper mapper;

    @Override
    public Optional<Category> findById(String id) {
        Optional<CategoryEntity> optionalCategoryEntity = service.findById(id);
        if(!optionalCategoryEntity.isEmpty())
           return Optional.ofNullable(mapper.mapToDomain(optionalCategoryEntity.get()));
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = service.findAll();
        return mapper.mapToDomain(categoryEntities);
    }
}
