package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static boolean isSubstring(String input, String search) {
        Pattern pattern = Pattern.compile(input);
        Matcher matcher = pattern.matcher(search);
        return matcher.find();
    }
}
