package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    static Stream<Arguments> argumentsStreamFirst() {
        return Stream.of(
            Arguments.of("0000", true),
            Arguments.of("0010", false),
            Arguments.of("110111", true)
        );
    }
    static Stream<Arguments> argumentsStreamSecond() {
        return Stream.of(
            Arguments.of("000000", true),
            Arguments.of("111111", true),
            Arguments.of("01", false)
        );
    }
    static Stream<Arguments> argumentsStreamThird() {
        return Stream.of(
            Arguments.of("00", true),
            Arguments.of("0", true),
            Arguments.of("0000", false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsStreamFirst")
    void test(String input, boolean expected) {

        boolean actual = Task7.firstRegex(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("argumentsStreamSecond")
    void test2(String input, boolean expected) {

        boolean actual = Task7.secondRegex(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("argumentsStreamThird")
    void test3(String input, boolean expected) {

        boolean actual = Task7.thirdRegex(input);

        assertEquals(expected, actual);
    }

}
