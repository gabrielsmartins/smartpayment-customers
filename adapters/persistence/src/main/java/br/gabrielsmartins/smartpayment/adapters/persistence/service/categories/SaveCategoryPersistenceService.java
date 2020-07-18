package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCategoryPersistenceService implements ISaveCategoryPersistenceService {

    private final CategoryRepository repository;

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        return repository.save(categoryEntity);
    }
}
