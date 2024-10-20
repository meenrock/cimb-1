package com.cimb.question2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class util {
    public static boolean IsFirstRevisionFormat(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*([.|][0-9])([.|][0-9]*)?$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static boolean IsSecondRevisionFormat(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*([.|][0-9]*)?$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static ArrayList<Integer> truncateVersion(String string) {
        if (string.isEmpty()) {
            return null;
        }
        String[] splitted = string.split("\\.");
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            intArr.add(Integer.parseInt(splitted[i].replaceFirst("^0+(?!$)", "")));
        }
        return intArr;
    }

}
