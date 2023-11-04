package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CallingInfoTest {
    @Test
    public void testCallingInfo() {
        CallingInfo callingInfo = Task4.callingInfo(new Throwable());

        String className = callingInfo.className();
        String methodName = callingInfo.methodName();

        assertThat(className).isEqualTo("edu.hw2.TestForTask4");
        assertThat(methodName).isEqualTo("testCallingInfo");
    }
}
