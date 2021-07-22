package com.example.MaryCatqapi.dto.ParishesDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParishesChurchValidationDTO {
    //@NotNull
    private Long id;

    private String name;

    private String cnpj;

}
