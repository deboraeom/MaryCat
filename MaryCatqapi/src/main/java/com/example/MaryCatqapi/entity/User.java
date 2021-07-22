package com.example.MaryCatqapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth_date")
    private Date birthDate;


    @Column(name = "cellphone_number")
    private String cellphoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="address",referencedColumnName = "id")
    private UserAddress address;

//    @Column(name = "address")
//    private Long address;


    @Column(name = "cell_phone")
    private String cellPhone;


}