package edu.hw3;

public class Task1 {
    public static String atbash(String s) {
        char[] abc =
            new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] reverse_abc =
            new char[] {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
                'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

        StringBuffer res = new StringBuffer(s.length());
        for (char ch : s.toCharArray()) {
            if (isLatinLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    int k = new String(abc).indexOf(Character.toLowerCase(ch));
                    res.append(Character.toUpperCase(reverse_abc[k]));
                    // res.append((char) ('A' + 'Z' - c));
                } else if (Character.isLowerCase(ch)) {
                    int k = new String(abc).indexOf(ch);
                    res.append(reverse_abc[k]);
                    // res.append((char) ('a' + 'z' - c));
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private static boolean isLatinLetter(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }


}
