package br.gabrielsmartins.smartpayment.adapters.persistence.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-04T08:19:56-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Ubuntu)"
)
@Component
public class CategoryPersistenceMapperImpl implements CategoryPersistenceMapper {

    @Override
    public Category mapToDomain(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryEntity.getId() );
        category.setDescription( categoryEntity.getDescription() );

        return category;
    }

    @Override
    public List<Category> mapToDomain(List<CategoryEntity> categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryEntity.size() );
        for ( CategoryEntity categoryEntity1 : categoryEntity ) {
            list.add( mapToDomain( categoryEntity1 ) );
        }

        return list;
    }

    @Override
    public CategoryEntity mapToEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setDescription( category.getDescription() );

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> mapToEntity(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryEntity> list = new ArrayList<CategoryEntity>( category.size() );
        for ( Category category1 : category ) {
            list.add( mapToEntity( category1 ) );
        }

        return list;
    }
}
