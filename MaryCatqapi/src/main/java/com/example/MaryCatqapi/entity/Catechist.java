package com.example.MaryCatqapi.entity;


import com.example.MaryCatqapi.enums.CatechistType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Catechist ")
@Table(name = "catechists")
public class Catechist {

    @Id
    @Column(name="", nullable = false)
    private Long usersId;

    @Id
    @Column(name="churches_id",nullable = false)
    private Long churchesId;

    @Column(name="type",nullable = false)
    private CatechistType type;

    @Column(name="add_catechumen")
    private Boolean addCatechumen;

    @Column(name="delete_catechumen")
    private Boolean deleteCatechumen;

    @Column(name="update_catechumen")
    private  Boolean updateCatechumen;




}
