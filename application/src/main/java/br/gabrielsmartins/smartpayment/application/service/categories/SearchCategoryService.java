package br.gabrielsmartins.smartpayment.application.service.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SearchCategoryUseCase;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SearchCategoryPort;
import br.gabrielsmartins.smartpayment.common.stereotype.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SearchCategoryService implements SearchCategoryUseCase {

    private final SearchCategoryPort port;

    @Override
    public Optional<Category> findById(String id) {
        return port.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return port.findAll();
    }
}
