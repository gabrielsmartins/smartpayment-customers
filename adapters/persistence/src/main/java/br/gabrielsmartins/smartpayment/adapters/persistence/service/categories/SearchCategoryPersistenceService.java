package br.gabrielsmartins.smartpayment.adapters.persistence.service.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SearchCategoryPersistenceService implements ISearchCategoryPersistenceService {

    private final CategoryRepository repository;

    @Override
    public Optional<CategoryEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
}
