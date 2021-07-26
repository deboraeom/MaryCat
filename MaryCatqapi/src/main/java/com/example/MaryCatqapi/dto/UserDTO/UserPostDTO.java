package com.example.MaryCatqapi.dto.UserDTO;

import com.example.MaryCatqapi.dto.UserAddress.UserAddressPostDTO;
import com.example.MaryCatqapi.entity.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {

    private Long id;

    private Date birthDate;

    private String cellphoneNumber;

    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo cpf")
    private String email;

    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo cpf")
    private String name;

    @NotEmpty @NotNull @Size(min = 2, max = 255, message="Preencha corretamente o campo cpf")
    private String password;

    private String phoneNumber;

    //private Long address;
    @Valid
    private UserAddressPostDTO address;

   // private String cellPhone;


}
