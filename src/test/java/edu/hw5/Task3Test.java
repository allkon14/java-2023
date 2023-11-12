package edu.hw5;

import edu.hw5.task3.AbstractDateParser;
import edu.hw5.task3.SimpleDateParser;
import edu.hw5.task3.Task3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import static edu.hw5.task3.Task3.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    static Stream<Arguments> argumentsStream() {
        return Stream.of(
            Arguments.of(
                "2020-10-10",
                Optional.of(LocalDate.of(2020, 10, 10))
            ),
            Arguments.of(
                "1/3/1976",
                Optional.of(LocalDate.of(1976, 3, 1))
            ),
            Arguments.of(
                "today",
                Optional.of(LocalDate.now())
            ),
            Arguments.of(
                "3 days ago",
                Optional.of(LocalDate.now().minusDays(3))
            ),
            Arguments.of(
                "1 year after",
                Optional.of(LocalDate.now().plusYears(1))
            ),
            Arguments.of(
                "tu tu tu",
                Optional.empty()
            )
        );
    }
    @ParameterizedTest
    @MethodSource("argumentsStream")
    void test(String input, Optional<LocalDate> expected) {

        Optional<LocalDate> actual = parseDate(input);

        assertEquals(expected, actual);
    }
}
