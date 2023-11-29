package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Tests {
    @Test
    void test1() {
        TreeMap<String, String> treeMap = new NullTreeMap<>();

        treeMap.put(null, "test");

        assertThat(treeMap.containsKey(null)).isTrue();
    }
}
