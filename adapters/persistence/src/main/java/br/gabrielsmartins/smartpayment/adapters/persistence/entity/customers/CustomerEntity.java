package br.gabrielsmartins.smartpayment.adapters.persistence.entity.customers;


import br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories.CategoryEntity;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class CustomerEntity {

    private String id;
    private String name;
    private DocumentType documentType;
    private String documentNumber;
    private CategoryEntity category;
}
