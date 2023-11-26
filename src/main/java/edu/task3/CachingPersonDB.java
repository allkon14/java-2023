package edu.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingPersonDB implements PersonDB {
    HashMap<Integer, Person> persons = new HashMap<>();
    HashMap<String, List<Integer>> nameMap = new HashMap<>();
    HashMap<String, List<Integer>> addressMap = new HashMap<>();
    HashMap<String, List<Integer>> phoneMap = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (persons.containsKey(person.id())) {
            return;
        }

        persons.put(person.id(), person);
        addPersonToIndex(nameMap, person.name(), person.id());
        addPersonToIndex(addressMap, person.address(), person.id());
        addPersonToIndex(phoneMap, person.phoneNumber(), person.id());
    }

    private void addPersonToIndex(Map<String, List<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(id);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = persons.remove(id);
        if (person != null) {
            removeFromIndex(nameMap, person.name(), id);
            removeFromIndex(addressMap, person.address(), id);
            removeFromIndex(phoneMap, person.phoneNumber(), id);
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
        return nameMap.get(name).stream()
            .map(persons::get)
            .toList();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressMap.get(address).stream()
            .map(persons::get)
            .toList();
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return phoneMap.get(phone).stream()
            .map(persons::get)
            .toList();
    }

}
