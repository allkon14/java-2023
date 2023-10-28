package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ContactBook {

    private ContactBook() {
    }

    private final static String ASCENDING_ORDER = "ASC";
    private final static String DESCENDING_ORDER = "DESC";

    public static List<Contact> parseContacts(String[] contactStrs, String sortOrder) {
        if (contactStrs == null || contactStrs.length == 0) {
            return List.of();
        }
        return Arrays
            .stream(contactStrs)
            .map(ContactBook::parseContact)
            .sorted(getParseSortOrder(sortOrder))
            .toList();
    }

    private static Contact parseContact(String contactStr) {
        if (contactStr.isEmpty()) {
            throw new IllegalArgumentException("Contact must not be empty!");
        }
        String[] fullName = contactStr.split("\\s+");
        String name = null;
        String surname = null;
        if (fullName.length > 0) {
            name = fullName[0];
        }
        if (fullName.length > 1) {
            surname = fullName[1];
        }
        return new Contact(name, surname);
    }

    private static Comparator<Contact> getParseSortOrder(String sortOrder) {
        if (sortOrder.equals(ASCENDING_ORDER)) {
            return Comparator.naturalOrder();
        } else if (sortOrder.equals(DESCENDING_ORDER)) {
            return Comparator.reverseOrder();
        }
        throw new IllegalArgumentException("Invalid sort order!");
    }
}
