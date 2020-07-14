package com.toranj.ghabz.utils;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Validation {
    public static boolean isValidNationalCode(String input) {
        if (!input.matches("^\\d{10}$"))
            return false;
        int check = Integer.parseInt(input.substring(9, 10));
        int sum = IntStream.range(0, 9).map((IntUnaryOperator) x -> Integer.parseInt(input.substring(x, x + 1)) * (10 - x)).sum() % 11;
        return (sum < 2 && check == sum) || (sum >= 2 && check + sum == 11);
    }

    //regex for mobile
    public static boolean isValidMobile(String input) {
        if (!input.matches("^[0][9][0-9][0-9]{8,8}$"))
            return false;
        return true;
    }

    //regex for email
    public static boolean isValidEmail(String input) {
        if (!input.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
            return false;
        return true;
    }

    //regex for birthDate
    public static boolean isValidBirthDate(String input) {
        if (!input.matches("^\\d{4}[\\ -\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$"))
            return false;
        return true;
    }

}
