package com.mikado.mikadosaas.common.util;

public enum FilterModes {
    equals("equals"),
    range("range"),
    like("like"),
    leftlike("leftlike"),
    lightlike("rightlike"),
    in("in");

    private final String value;

    FilterModes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
