package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    public void testValidNumberPlate() {
        assertThat(Task5.isValidNumberPlate("А123ВЕ777")).isEqualTo(true);
        assertThat(Task5.isValidNumberPlate("О777ОО177")).isEqualTo(true);
        assertThat(Task5.isValidNumberPlate("123АВЕ777")).isEqualTo(false);
        assertThat(Task5.isValidNumberPlate("А123ВГ77")).isEqualTo(false);
        assertThat(Task5.isValidNumberPlate("А123ВЕ7777")).isEqualTo(false);
    }

}
