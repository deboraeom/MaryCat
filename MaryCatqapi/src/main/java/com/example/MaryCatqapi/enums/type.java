package com.example.MaryCatqapi.enums;

public enum type {
    Paróquia("Paróquia"),
    Comunidade("Comunidade");

    private final String name;


    type(final String name){
        this.name= name;

    }

    public String getName() {
        return name;
    }
}
