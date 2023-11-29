package edu.hw3;

public class Task1 {
    final static char[] ABC =
        new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    final static char[] REVERSE_ABC =
        new char[] {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
            'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

    public static String atbash(String s) {
        StringBuffer res = new StringBuffer(s.length());
        for (char ch : s.toCharArray()) {
            if (isLatinLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    int k = new String(ABC).indexOf(Character.toLowerCase(ch));
                    res.append(Character.toUpperCase(REVERSE_ABC[k]));
                } else if (Character.isLowerCase(ch)) {
                    int k = new String(ABC).indexOf(ch);
                    res.append(REVERSE_ABC[k]);
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
