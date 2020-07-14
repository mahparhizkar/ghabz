package com.toranj.ghabz.utils;

public enum Gender implements ValueText {
    MALE("01","مرد"),
    FEMALE("02","زن");

    private String value;
    private String text;

    Gender(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public String text() {
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getTextByValue(String value){
        for (Gender gender : Gender.values()) {
            if(gender.getValue().equals(value)) {
                return gender.getText();
            }
        }
        return null;
    }

}
