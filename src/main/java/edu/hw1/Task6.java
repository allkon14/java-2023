package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    public static int countK(int number, int... c) {
        int cnt = 0;
        if (c.length == 1) {
            cnt = c[0];
        }
        if (number == 6174) {
            return cnt;
        } else if (number <= 1000 || number >= 9999) {
            return -1;
        } else {
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = number % 10;
                number /= 10;
            }
            Arrays.sort(nums);
            int max_num = 0;
            int min_num = 0;
            for (int i = 0; i < 4; i++) {
                min_num += nums[i] * Math.pow(10, i);
                max_num += nums[3 - i] * Math.pow(10, i);
            }
            if (max_num - min_num != 0) {
                return countK(Math.abs(max_num - min_num), cnt + 1);
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        LOGGER.info(countK(3524));
    }
}
