package br.gabrielsmartins.smartpayment.adapters.web.adapter.in.categories;

import br.gabrielsmartins.smartpayment.adapters.web.dto.categories.CategoryDTO;
import br.gabrielsmartins.smartpayment.adapters.web.mapper.categories.CategoryWebMapper;
import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.ports.input.categories.SaveCategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class SaveCategoryController {

    private SaveCategoryUseCase useCase;
    private CategoryWebMapper mapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestHeader HttpHeaders httpHeaders, @RequestBody CategoryDTO categoryDTO){
        Category category = mapper.mapToDomain(categoryDTO);
        Category savedCategory = useCase.save(category);
        CategoryDTO categoryDTOResponse = mapper.mapToDTO(savedCategory);
        URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(categoryDTOResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryDTOResponse);
    }
}
