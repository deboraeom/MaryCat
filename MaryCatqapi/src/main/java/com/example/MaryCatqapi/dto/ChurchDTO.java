package com.example.MaryCatqapi.dto;

import com.example.MaryCatqapi.entity.Parish;
import com.example.MaryCatqapi.enums.type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChurchDTO {

    private Long id;

    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo nome")
    private String name;

    @Email(message = "Email não válido")
    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo email")
    private String email;

    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo phone_number")
    private String phone_number;

    @NotNull(message="Preencha corretamente o campo Type")
    @Enumerated(EnumType.STRING)
    private type type;

    @NotNull @NotEmpty @NotBlank(message="Preencha corretamente o campo paróquia")
    private Parish parishes_id;
}
