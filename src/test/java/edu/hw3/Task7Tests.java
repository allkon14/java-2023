package edu.hw3;

import java.util.TreeMap;
import edu.hw3.Task7.NullTreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Tests {
    @Test
    void test1() {
        TreeMap<String, String> treeMap = new NullTreeMap<>();

        treeMap.put(null, "test");

        assertThat(treeMap.containsKey(null)).isTrue();
    }
}
