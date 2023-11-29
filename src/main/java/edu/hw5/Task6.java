package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static boolean isSubstring(String sub, String src) {
        return src.matches(".*" + sub + ".*");
    }
}
