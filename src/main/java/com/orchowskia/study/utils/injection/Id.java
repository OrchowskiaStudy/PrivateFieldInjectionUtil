package com.orchowskia.study.utils.injection;
public class Id {
    private final String id;

    public Id(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}