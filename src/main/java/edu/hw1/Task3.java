package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

public class Task3 {

    public static boolean isNestable(int[] a, int[] b) {
        int min_a = Arrays.stream(a).min().getAsInt();
        int max_a = Arrays.stream(a).max().getAsInt();
        int min_b = Arrays.stream(b).min().getAsInt();
        int max_b = Arrays.stream(b).max().getAsInt();

        return min_a > min_b && max_a < max_b;
    }

    @Slf4j
    public static void main(String[] args) {
        LOGGER.info(isNestable(new int[] {3, 1}, new int[] {4, 0}));
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        LOGGER.info(isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
    }
}
