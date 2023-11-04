package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

public class Task5 {

    public static boolean isPalindromeDescendant(int num) {
        if (num < 10) {
            return false;
        }
        String str = String.valueOf(num);
        return isPalindromeDescendant(str);
    }

    public static boolean isPalindromeDescendant(String s) {
        if (s.length() == 1) {
            return false;
        }
        int len_s = s.length();
        boolean flag = true;
        for (int i = 0; i < len_s; i++) {
            flag &= (s.charAt(len_s - 1 - i) == s.charAt(i));
        }
        if (flag) {
            return true;
        } else {
            StringBuffer new_s = new StringBuffer();
            for (int i = 0; i < len_s; i += 2) {
                new_s.append(Integer.parseInt("" + s.charAt(i)) + Integer.parseInt("" + s.charAt(i + 1)));
            }
            return isPalindromeDescendant(new_s.toString());
        }
    }

    @Slf4j
    public static void main(String[] args) {
        LOGGER.info(isPalindromeDescendant(11211230));
    }
}
