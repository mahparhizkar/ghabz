package com.toranj.ghabz.utils;

public enum UserStatus implements ValueText {

    NOT_REGISTERED("00", "Not Registered"),
    ACTIVE("01", "Active"),
    DEACTIVE("02", "Deactive");

    private String text;
    private String value;

    private UserStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public String value() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}