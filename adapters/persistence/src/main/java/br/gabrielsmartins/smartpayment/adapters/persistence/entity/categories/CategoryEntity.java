package br.gabrielsmartins.smartpayment.adapters.persistence.entity.categories;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {

    private String id;
    private String description;

}
