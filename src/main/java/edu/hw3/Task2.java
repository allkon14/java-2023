package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {
    public static List<String> clusterize(String str) {
        List<String> result = new ArrayList<>();

        Stack<Character> stack = new Stack<>();

        int begIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar == '(') {
                stack.push(curChar);
            } else {
                stack.pop();
            }
            if (stack.empty()) {
                result.add(str.substring(begIndex, i + 1));
                begIndex = i + 1;
            }
        }

        return result;
    }

}
