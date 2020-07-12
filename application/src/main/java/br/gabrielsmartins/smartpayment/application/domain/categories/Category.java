package br.gabrielsmartins.smartpayment.application.domain.categories;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    private String id;
    private String description;

}
