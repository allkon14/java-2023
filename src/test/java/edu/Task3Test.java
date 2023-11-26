package edu;

import edu.task3.CachingPersonDBLock;
import org.junit.jupiter.api.Test;
import edu.task3.CachingPersonDB;
import edu.task3.Person;
import edu.task3.PersonDB;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Task3Test {
    private PersonDB database;

    static Arguments[] arguments() {
        return new Arguments[15];
    }

    @Test
    void testAdd() {
        database = new CachingPersonDB();

        Person person1 = new Person(1, "John", "123 Main St", "555-1234");
        Person person2 = new Person(2, "Alice", "456 Park Ave", "555-5678");

        database.add(person1);
        database.add(person2);

        List<Person> persons = database.findByName("John");
        assertEquals(1, persons.size());
        assertEquals(person1, persons.get(0));

        persons = database.findByAddress("456 Park Ave");
        assertEquals(1, persons.size());
        assertEquals(person2, persons.get(0));

        persons = database.findByPhone("555-5678");
        assertEquals(1, persons.size());
        assertEquals(person2, persons.get(0));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testSync() {
        database = new CachingPersonDB();

        List<Person> expected1 = List.of(new Person(1, "John", "123 Main St", "555-1234"));
        List<Person> expected2 = List.of(new Person(2, "Alice", "456 Park Ave", "555-5678"));

        Thread t1 = new Thread(() -> {
            database.add(new Person(1, "John", "123 Main St", "555-1234"));
            assertEquals(expected1, database.findByName("John"));
            assertEquals(expected1, database.findByAddress("123 Main St"));
            assertEquals(expected1, database.findByPhone("555-1234"));
        });

        Thread t2 = new Thread(() -> {
            database.add(new Person(2, "Alice", "456 Park Ave", "555-5678"));
            assertEquals(expected2, database.findByName("Alice"));
            assertEquals(expected2, database.findByAddress("456 Park Ave"));
            assertEquals(expected2, database.findByPhone("555-5678"));
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            fail("InterruptedException occurred");
        }
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testRWLocks() {
        database = new CachingPersonDBLock();

        List<Person> expected1 = List.of(new Person(1, "John", "123 Main St", "555-1234"));
        List<Person> expected2 = List.of(new Person(2, "Alice", "456 Park Ave", "555-5678"));

        Thread t1 = new Thread(() -> {
            database.add(new Person(1, "John", "123 Main St", "555-1234"));
            assertEquals(expected1, database.findByName("John"));
            assertEquals(expected1, database.findByAddress("123 Main St"));
            assertEquals(expected1, database.findByPhone("555-1234"));
        });

        Thread t2 = new Thread(() -> {
            database.add(new Person(2, "Alice", "456 Park Ave", "555-5678"));
            assertEquals(expected2, database.findByName("Alice"));
            assertEquals(expected2, database.findByAddress("456 Park Ave"));
            assertEquals(expected2, database.findByPhone("555-5678"));
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            fail("InterruptedException occurred");
        }
    }
}
