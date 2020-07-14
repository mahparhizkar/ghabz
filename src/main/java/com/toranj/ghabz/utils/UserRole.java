package com.toranj.ghabz.utils;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserRole implements ValueText2 {
    ADMIN(1,"ROLE_Admin"),
    COMMON(2,"ROLE_Common"),
    POWER(3,"ROLE_Power"),
    SUPPORT(4,"ROLE_Support");

    private int value;
    private String text;


    UserRole(int value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public int value() {
        return value;
    }

    public int getValue() { return value; }

    public String getText() { return text; }

    public static List<String> getSomeRoles(){
        List<String> userRoles = Stream.of(UserRole.values())
                .map(UserRole::getText)
                .collect(Collectors.toList());
        userRoles.remove(0);
        return userRoles;
    }

}
