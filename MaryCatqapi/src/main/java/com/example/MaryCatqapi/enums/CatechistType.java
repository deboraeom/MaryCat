package com.example.MaryCatqapi.enums;

public enum CatechistType {

    coordenadorParoquial("Coordenador Paroquial"),
    coordenadorComunitario("Coordenador Comunitário"),
    catequista("Catequista");


    private final String name;


    CatechistType(final String name){
        this.name= name;

    }

    public String getName() {
        return name;
    }
}
