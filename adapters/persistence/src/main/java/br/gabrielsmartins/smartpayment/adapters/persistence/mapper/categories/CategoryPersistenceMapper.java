package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
builder = @Builder(disableBuilder = true))
public interface CategoryPersistenceMapper {

    Category mapToDomain(CategoryEntity categoryEntity);
    List<Category> mapToDomain(List<CategoryEntity> categoryEntity);

    CategoryEntity mapToEntity(Category category);
    List<CategoryEntity> mapToEntity(List<Category> category);
}
