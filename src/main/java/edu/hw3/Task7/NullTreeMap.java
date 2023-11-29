package edu.hw3.Task7;

import java.util.Comparator;

import java.util.TreeMap;

public class NullTreeMap<K, V> extends TreeMap<K, V> {
    private static final Comparator<Comparable<Object>> NULL_COMPARATOR = new NullComparator();

    public NullTreeMap() {
        super(getComparator());
    }

    private static <T> Comparator<T> getComparator() {
        return (Comparator<T>) NULL_COMPARATOR;
    }

    private final static class NullComparator implements Comparator<Comparable<Object>> {
        @Override
        public int compare(Comparable<Object> o1, Comparable<Object> o2) {
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }

            return o1.compareTo(o2);
        }
    }
}
