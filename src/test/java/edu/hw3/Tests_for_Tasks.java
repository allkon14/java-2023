package edu.hw3;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task2.clusterize;
import static edu.hw3.Task3.freqDict;
import static edu.hw3.Task4.convertToRoman;
import static edu.hw3.Task5.ContactBook.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests_for_Tasks {
    @Test
    void Task2() {
        String str = "((()))(())()()(()())";
        List<String> result = clusterize(str);
        List<String> expectedResult = List.of("((()))", "(())", "()", "()", "(()())");
        assertEquals(result, expectedResult);

        result = clusterize("((()))(())()()(()())");
        expectedResult = List.of("((()))", "(())", "()", "()", "(()())");
        assertEquals(result, expectedResult);

    }

    @Test
    void Task3() {

        String[] val = new String[] {"a", "bb", "a", "bb"};

        assertEquals(freqDict(val), Map.of("bb", 2, "a", 2));
        assertEquals(freqDict(new Boolean[] {true, true, true, false}), Map.of(true, 3, false, 1));
        assertEquals(freqDict(new Integer[] {1, 1, 2, 2}), Map.of(1, 2, 2, 2));
    }

    @Test
    void Task4() {
        assertEquals(convertToRoman(2), "II");
        assertEquals(convertToRoman(2089), "MMLXXXIX");
        assertEquals(convertToRoman(12), "XII");
        assertEquals(convertToRoman(16), "XVI");
        assertEquals(convertToRoman(3999), "MMMCMXCIX");
    }

    @Test
    void Task5() {
        assertEquals(
            parseContacts(new String[] {
                "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC"),
            List.of(
                new Contact("Thomas", "Aquinas"),
                new Contact("Rene", "Descartes"),
                new Contact("David", "Hume"),
                new Contact("John", "Locke")
            )
        );
        assertEquals(
            parseContacts(new String[] {
                "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "DESC"),
            List.of(
                new Contact("John", "Locke"),
                new Contact("David", "Hume"),
                new Contact("Rene", "Descartes"),
                new Contact("Thomas", "Aquinas")
            )
        );
    }

}
