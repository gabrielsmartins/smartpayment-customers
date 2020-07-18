package br.gabrielsmartins.smartpayment.application.domain.customers;


import br.gabrielsmartins.smartpayment.application.domain.categories.Category;
import br.gabrielsmartins.smartpayment.application.domain.enums.DocumentType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Customer {

    private String id;
    private String name;
    private DocumentType documentType;
    private String documentNumber;
    private Category category;

}
