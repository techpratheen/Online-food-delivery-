package com.tech.pro.enums;

public enum RestaurantType {

    VEG("V"), NON_VEG("N");

    private String code;

    RestaurantType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
