package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(this.map.containsKey(name)) {
            this.map.get(name).add(phoneNumber);
        } else {
            this.map.put(name, new ArrayList<>());
            this.map.get(name).add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        if(this.map.containsKey(name)) {
            this.map.get(name).addAll(Arrays.asList(phoneNumbers));
        } else {
            this.map.put(name, Arrays.asList(phoneNumbers));
        }
    }

    public void remove(String name) {
        this.map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        for (Map.Entry e : this.map.entrySet()) {
            List<String> l = (List)e.getValue();
            for (String s : l) {
                if (s.equals(phoneNumber)) {
                    return (String)e.getKey();
                }
            }
        }
        return null;

    }

    public List<String> getAllContactNames() {
        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        return list;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
