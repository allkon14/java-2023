package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static <T> Map<T, Integer> freqDict(T[] a){
        Map<T, Integer> dict = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            dict.put(a[i], 0);
        }
        for (int i = 0; i < a.length; i++) {
            int temp = dict.get(a[i]);
            temp++;
            dict.put(a[i], temp);
        }
        return dict;
    }
}
