package edu;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {
    @Test
    public void test5() {
        int number = 5;

        BigInteger expected = BigInteger.valueOf(120);
        BigInteger actual = Task2.factorial(number);

        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        int number = 10;

        BigInteger expected = BigInteger.valueOf(3628800);
        BigInteger actual = Task2.factorial(number);

        assertEquals(expected, actual);
    }
}
