package edu.hw5;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class Task2Test {
    @Test
    public void testFindFridaysTheThirteenth() {
        int year = 2024;
        List<LocalDate> result = Task2.findFridaysTheThirteenth(year);

        List<LocalDate> expected = List.of(LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindNextFridayTheThirteenth() {
        LocalDate date = LocalDate.of(2023, 2, 1);
        LocalDate result = Task2.findNextFridayTheThirteenth(date);
        LocalDate expected = LocalDate.of(2023, 10, 13);
        assertThat(result).isEqualTo(expected);
    }
}
