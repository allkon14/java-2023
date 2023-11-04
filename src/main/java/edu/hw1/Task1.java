package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

public class Task1 {

    public static int minutesToSeconds(String timeStr) {
        var time = timeStr.split(":");
        if (time.length != 2) {
            return -1;
        } else {
            int t0 = 0;
            int t1 = 0;
            try {
                t0 = Integer.parseInt(time[0]);
                t1 = Integer.parseInt(time[1]);
            } catch (Exception e) {
                return -1;
            }
            if (t0 >= 0 && t1 >= 0 && t1 < 60) {
                return t0 * 60 + t1;
            } else {
                return -1;
            }
        }
    }

    @Slf4j
    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("one:zero"));
        LOGGER.info(minutesToSeconds("3:07"));
        LOGGER.info(minutesToSeconds("2:67"));
        LOGGER.info(minutesToSeconds("20000:00"));
    }
}
