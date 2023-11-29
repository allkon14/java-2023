package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    public void testIsSubstring() {
        assertThat(Task6.isSubstring("abc", "achfdbaabgabcaabg")).isEqualTo(true);
        assertThat(Task6.isSubstring("abc", "acb")).isEqualTo(false);
        assertThat(Task6.isSubstring("123", "1a2b3c")).isEqualTo(false);
        assertThat(Task6.isSubstring("def", "def")).isEqualTo(true);
        assertThat(Task6.isSubstring("xyz", "xzy")).isEqualTo(false);
    }

}
