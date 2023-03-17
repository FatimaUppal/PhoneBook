package com.zipcodewilmington.phonebook;

import org.codehaus.plexus.interpolation.SimpleRecursionInterceptor;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook=map; // setting phonebook equal to map
    }

    public PhoneBook() {
       this.phonebook=new LinkedHashMap<>();// putting phonebook into linked hashmap so that the order wont mess up
    }

    public void add(String name, String phoneNumber) {
        List<String> newNum= new ArrayList<>();
        newNum.add(phoneNumber);
        this.phonebook.putIfAbsent(name,newNum);

    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> newNum= new ArrayList<>();
        newNum.addAll(List.of(phoneNumbers));
        this.phonebook.putIfAbsent(name,newNum);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (String number : phonebook.keySet()) {
            if (phonebook.get(number).contains(phoneNumber)) {
                return number;
            }
        }return null;
    }

    public List<String> getAllContactNames() {
        List<String> list= new ArrayList<String>();             //new array list for map phonebook
        this.phonebook.keySet().forEach(key -> list.add(key));  //uses keySet method to get set of all keys in tha map and iterates
        return list;                                            //over all of them with forEach method and key -> list.add(key) tak
                                                                // each key in set and adds to the list
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
