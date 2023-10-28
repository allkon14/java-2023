package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static String convertToRoman(int num) {
        Map<Integer, String> nums = new HashMap<>();
        nums.put(0, "");
        nums.put(1, "I");
        nums.put(5, "V");
        nums.put(10, "X");
        nums.put(50, "L");
        nums.put(100, "C");
        nums.put(500, "D");
        nums.put(1000, "M");
        StringBuilder ans = new StringBuilder();
        int rank = 1;
        while (num > 0) {
            int curr = num % 10 * rank;
            num /= 10;
            if (nums.containsKey(curr)) {
                ans.append(nums.get(curr));
            } else {
                if (curr < 5 * rank) {
                    if (curr == 4 * rank) {
                        ans.append(nums.get(rank * 5)).append(nums.get(rank));
                    } else {
                        ans.append(nums.get(rank).repeat(curr / rank));
                    }
                } else {
                    if (curr == 9 * rank) {
                        ans.append(nums.get(rank * 10)).append(nums.get(rank));
                    } else {
                        ans.append(nums.get(rank).repeat(curr / rank - 5)).append(nums.get(rank * 5));
                    }
                }
            }
            rank *= 10;
        }
        return ans.reverse().toString();
    }
}
