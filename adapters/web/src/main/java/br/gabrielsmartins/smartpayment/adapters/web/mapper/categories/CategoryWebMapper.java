package br.gabrielsmartins.smartpayment.adapters.web.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE,
builder = @Builder(disableBuilder = true))
public interface CategoryWebMapper {

    Category mapToDomain(CategoryDTO categoryDTO);

    List<Category> mapToDomain(List<CategoryDTO> categoryDTO);

    CategoryDTO mapToDTO(Category category);

    List<CategoryDTO> mapToDTO(List<Category> category);

}
