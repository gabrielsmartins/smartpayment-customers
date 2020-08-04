package br.gabrielsmartins.smartpayment.adapters.web.adapter.in.categories;

import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SearchCategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class SearchCategoryController {

    private SearchCategoryUseCase useCase;
    private CategoryWebMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        Optional<Category> optionalCategory = useCase.findById(id);
        if(optionalCategory.isPresent())
            return new ResponseEntity<>(mapper.mapToDTO(optionalCategory.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        List<Category> categories = useCase.findAll();
        List<CategoryDTO> categoryDTOS = mapper.mapToDTO(categories);
        if(categoryDTOS.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }
}
