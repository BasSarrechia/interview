package com.example;

public class Records {
    public static void main(String[] args) {
        Person person = new Person("Thomas");
        System.out.println(person);
    }
}
record Person(int age, String name) {
    Person {
        if(age < 18) {
            System.out.println("underage");
        }
    }

    Person(String name) {
        this(0, name);
    }
}