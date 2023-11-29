package edu.hw3;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw3.Task5.ContactBook.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Tests {
    @Test
    void test1() {
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

    }

    @Test
    void test2() {
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
