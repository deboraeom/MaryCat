package com.example.MaryCatqapi.dto.ChurchAddressDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChurchAddressPostDTO {
    private Long id;

    @NotNull(message="Address Number can't be null")
    private String addressesNumber;

    @NotNull(message="Street Number can't be null")
    private String street;

    @NotNull(message="Neighborhood Number can't be null")
    private String neighborhood;

    @NotNull(message="City Number can't be null")
    private String city;

    @NotNull(message="UF Number can't be null")
    private String uf;
//
}
