package com.example.MaryCatqapi.dto.ParishesDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParishDTO {

    private Long id;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255, message="Preencha corretamente o campo nome")
    private String name;

    //@CNPJ
    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo cpf")
    private String cnpj;

}
