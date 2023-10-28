package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> clusterize(String str) {
        if (str == null || !str.matches("[()]+")) {
            throw new IllegalStateException("Invalid input!");
        }
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int bracketCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                bracketCounter -= 1;
            } else {
                bracketCounter += 1;
            }
            temp.append(c);
            if (bracketCounter == 0) {
                ans.add(temp.toString());
                temp.setLength(0);
            } else if (bracketCounter < 0) {
                throw new IllegalStateException("Invalid input!");
            }
        }
        if (bracketCounter != 0) {
            throw new IllegalStateException("Invalid input!");
        }
        return ans;
    }

}
