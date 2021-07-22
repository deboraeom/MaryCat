package com.example.MaryCatqapi.entity;

import lombok.*;
import javax.persistence.*;

import com.example.MaryCatqapi.enums.type;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "churches")
@Table(name = "churches")
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone_number;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private type type;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "parishes_id" ,referencedColumnName = "id")
   private Parish parishes_id;


}
