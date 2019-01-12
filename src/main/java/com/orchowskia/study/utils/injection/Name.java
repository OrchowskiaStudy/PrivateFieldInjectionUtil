package com.orchowskia.study.utils.injection;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
