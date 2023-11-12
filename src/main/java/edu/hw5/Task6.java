package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static boolean isSubstring(String S, String T) {
        String regex = ".*" + Pattern.quote(S) + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(T);
        return matcher.find();
    }
}
