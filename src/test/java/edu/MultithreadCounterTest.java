package edu;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultithreadCounterTest {
    @Test
    void test1() {
        var counter = new MultithreadCounter();

        assertThat(counter.countToNumber(-1, 1)).isEqualTo(0);
    }

    @Test
    void test2() {
        var counter = new MultithreadCounter();
        assertThat(counter.countToNumber(1, 0)).isEqualTo(0);
    }

    @Test
    void test3() {
        var counter = new MultithreadCounter();
        assertThat(counter.countToNumber(1, -1)).isEqualTo(0);
    }

    @Test
    void test4() {
        var counter = new MultithreadCounter();
        assertThat(counter.countToNumber(1_000_000, 1)).isEqualTo(1_000_000);
    }

    @Test
    void test5() {
        var counter = new MultithreadCounter();
        assertThat(counter.countToNumber(1_000_000, 8)).isEqualTo(1_000_000);
    }
}
