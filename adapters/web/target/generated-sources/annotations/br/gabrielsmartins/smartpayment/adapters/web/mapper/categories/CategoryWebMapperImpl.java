package br.gabrielsmartins.smartpayment.adapters.web.mapper.categories;

import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-02T22:23:26-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Ubuntu)"
)
@Component
public class CategoryWebMapperImpl implements CategoryWebMapper {

    @Override
    public Category mapToDomain(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setDescription( categoryDTO.getDescription() );

        return category;
    }

    @Override
    public List<Category> mapToDomain(List<CategoryDTO> categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDTO.size() );
        for ( CategoryDTO categoryDTO1 : categoryDTO ) {
            list.add( mapToDomain( categoryDTO1 ) );
        }

        return list;
    }

    @Override
    public CategoryDTO mapToDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setDescription( category.getDescription() );

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> mapToDTO(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( category.size() );
        for ( Category category1 : category ) {
            list.add( mapToDTO( category1 ) );
        }

        return list;
    }
}
