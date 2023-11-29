package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {
    @Test
    void test1() {
        String str = "((()))(())()()(()())";
        List<String> result = clusterize(str);
        List<String> expectedResult = List.of("((()))", "(())", "()", "()", "(()())");
        assertEquals(result, expectedResult);
    }

    @Test
    void test2() {
        var result = clusterize("((()))(())()()(()())");
        var expectedResult = List.of("((()))", "(())", "()", "()", "(()())");
        assertEquals(result, expectedResult);
    }
    @Test
    void test3() {
        var result = clusterize("((()))");
        var expectedResult = List.of("((()))");
        assertEquals(expectedResult, result);
    }
}
