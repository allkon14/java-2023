package edu.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachingPersonDBLock implements PersonDB {
    HashMap<Integer, Person> persons = new HashMap<>();
    HashMap<String, List<Integer>> nameMap = new HashMap<>();
    HashMap<String, List<Integer>> addressMap = new HashMap<>();
    HashMap<String, List<Integer>> phoneMap = new HashMap<>();

    ReadWriteLock rwlock = new ReentrantReadWriteLock(true);

    @Override
    public synchronized void add(Person person) {
        int id = person.id();
        if (persons.containsKey(id)) {
            return;
        }

        rwlock.writeLock().lock();
        try {
            persons.put(person.id(), person);
            addPersonToIndex(nameMap, person.name(), id);
            addPersonToIndex(addressMap, person.address(), id);
            addPersonToIndex(phoneMap, person.phoneNumber(), id);
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    private void addPersonToIndex(Map<String, List<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(id);
    }

    @Override
    public synchronized void delete(int id) {
        rwlock.writeLock().lock();
        try {
            Person person = persons.remove(id);
            if (person != null) {
                removeFromIndex(nameMap, person.name(), id);
                removeFromIndex(addressMap, person.address(), id);
                removeFromIndex(phoneMap, person.phoneNumber(), id);
            }
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.get(key);
        if (ids != null) {
            ids.remove(Integer.valueOf(id));
            if (ids.isEmpty()) {
                index.remove(key);
            }
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        rwlock.readLock().lock();
        try {
            return nameMap.get(name).stream()
                .map(persons::get)
                .toList();
        } finally {
            rwlock.readLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        rwlock.readLock().lock();
        try {
            return addressMap.get(address).stream()
                .map(persons::get)
                .toList();
        } finally {
            rwlock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        rwlock.readLock().lock();
        try {
            return phoneMap.get(phone).stream()
                .map(persons::get)
                .toList();
        } finally {
            rwlock.readLock().unlock();
        }
    }

}
