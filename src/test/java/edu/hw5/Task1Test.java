package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static edu.hw5.Task1.calculateAverageSessionDuration;
import static edu.hw5.Task1.formatDuration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    public void Test1() {
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );

        Duration expected = calculateAverageSessionDuration(sessions);

        Duration result = Duration.ofHours(3).plusMinutes(40);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void Test2() {
        List<String> sessions = List.of(
            "2022-05-01, 20:20 - 2022-05-02, 00:20",
            "2022-04-01, 17:30 - 2022-04-01, 23:30"
        );

        String expected = formatDuration(calculateAverageSessionDuration(sessions));

        String result = formatDuration(Duration.ofHours(5).plusMinutes(0));

        assertThat(result).isEqualTo(expected);
    }
}
