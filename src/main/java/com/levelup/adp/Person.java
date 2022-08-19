package com.levelup.adp;

import java.util.*;

public class Person {
    String name;
    int age ;
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public static void main(String [] args) {
        List<Person> persons = Arrays.asList(
                new Person("Joe", 26),
                new Person("Siva", 33),
                new Person("David", 23),
                new Person("Chris", 26),
                new Person("Joe", 42));
        Map<Integer,List<Person>> grpPersonByAgeMap=new HashMap<Integer,List<Person>>();
        for (Person person:persons) {
        if(grpPersonByAgeMap.size()==0||grpPersonByAgeMap.get(person.age)==null){
            List<Person> personLst=new ArrayList<>();
            personLst.add(person);
            grpPersonByAgeMap.put(person.age,personLst);
        }else if(grpPersonByAgeMap.get(person.age)!=null){
            List personLst=grpPersonByAgeMap.get(person.age);
                personLst.add(person);
            grpPersonByAgeMap.put(person.age,personLst);
            }
        }
        Set<Integer> keys=grpPersonByAgeMap.keySet();
        for (Integer key:keys ){
            List<Person> personList=grpPersonByAgeMap.get(key);
            System.out.println(key+":");
            for (Person person:personList) {
                System.out.println("\t"+person.name);
            }
        }

        }
    }

