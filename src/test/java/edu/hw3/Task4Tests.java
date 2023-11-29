package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Tests {
    @Test
    void test1() {
        assertEquals(convertToRoman(2), "II");
    }

    @Test
    void test2() {
        assertEquals(convertToRoman(2089), "MMLXXXIX");
    }

    @Test
    void test3() {
        assertEquals(convertToRoman(12), "XII");
    }

    @Test
    void test4() {
        assertEquals(convertToRoman(16), "XVI");
    }

    @Test
    void test5() {
        assertEquals(convertToRoman(3999), "MMMCMXCIX");
    }
}
