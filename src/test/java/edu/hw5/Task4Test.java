package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    public void testCheckPassword() {
        assertThat(Task4.checkPassword("password")).isEqualTo(false);
        assertThat(Task4.checkPassword("1234524")).isEqualTo(false);
        assertThat(Task4.checkPassword("pass@word")).isEqualTo(true);
        assertThat(Task4.checkPassword("pa$$word")).isEqualTo(true);
        assertThat(Task4.checkPassword("passw#rd")).isEqualTo(true);
        assertThat(Task4.checkPassword("password!")).isEqualTo(true);
        assertThat(Task4.checkPassword("@@!!")).isEqualTo(true);
    }
}
