package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static edu.hw3.Task3.freqDict;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Tests {
    @Test
    void Task3() {

        String[] val = new String[] {"a", "bb", "a", "bb"};
        assertEquals(freqDict(val), Map.of("bb", 2, "a", 2));

        assertEquals(freqDict(new Boolean[] {true, true, true, false}), Map.of(true, 3, false, 1));

        assertEquals(freqDict(new Integer[] {1, 1, 2, 2}), Map.of(1, 2, 2, 2));
    }
    @Test
    void task2() {}
    @Test
    void task3() {}

}
