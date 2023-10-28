package edu.hw3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Tests_hw3_Task1 {
    @Test
    void test1() {
        String expectedResult = "Svool dliow!";
        assertEquals(expectedResult, Task1.atbash("Hello world!"));
    }
    @Test
    void test2() {
        String expectedResult = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertEquals(expectedResult, Task1.atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"));

    }


}
