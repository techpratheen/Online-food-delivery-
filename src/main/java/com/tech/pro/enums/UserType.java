package com.tech.pro.enums;

public enum UserType {
    USER("U"), ADMIN("A"), OWNER("O");

    private String Code;

    UserType(String code) {
        Code = code;
    }

    public String getCode() {
        return Code;
    }
}
