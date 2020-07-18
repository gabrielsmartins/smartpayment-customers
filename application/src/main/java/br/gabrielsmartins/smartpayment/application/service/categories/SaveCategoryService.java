package br.gabrielsmartins.smartpayment.application.service.categories;

import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SaveCategoryUseCase;
import br.gabrielsmartins.smartpayment.application.ports.ouput.categories.SaveCategoryPort;
import br.gabrielsmartins.smartpayment.common.stereotype.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveCategoryService implements SaveCategoryUseCase{

    private final SaveCategoryPort port;

    @Override
    public Category save(Category category) {
        return port.save(category);
    }
}
