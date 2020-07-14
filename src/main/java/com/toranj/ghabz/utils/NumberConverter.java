package com.toranj.ghabz.utils;

public class NumberConverter {

    public static String convertEnglishNumberToArabic(String number){
        try {
            char[] arabicCharacters = {'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};
            StringBuilder builder = new StringBuilder();
            for(int i =0;i<number.length();i++)
            {
                if(Character.isDigit(number.charAt(i)))
                {
                    builder.append(arabicCharacters[(int)(number.charAt(i))-48]);
                }
                else
                {
                    builder.append(number.charAt(i));
                }
            }
            return builder.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
