package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

public class Task4 {

    public static String fixString(String s) {
        int len_s = s.length();
        StringBuffer res = new StringBuffer(len_s);
        for (int i = 1; i < len_s; i += 2) {
            res.append(s.charAt(i));
            res.append(s.charAt(i - 1));
        }
        if (len_s % 2 == 1) {
            res.append(s.charAt(len_s - 1));
        }
        return res.toString();
    }

    @Slf4j
    public static void main(String[] args) {
        LOGGER.info(fixString("123456"));
        LOGGER.info(fixString("1454568"));
        LOGGER.info(fixString("214365"));
        LOGGER.info(fixString("оПомигети псаривьтс ртко!и"));
        LOGGER.info(fixString("hTsii  s aimex dpus rtni.g"));
        LOGGER.info(fixString("badce"));
    }
}
