package com.base.oom;

import java.util.ArrayList;

public class OOMTest {
    static ArrayList<Person> list = new ArrayList<Person>();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            Person person = new Person();
            list.add(person);
            person = null;
        }
        Thread.sleep(1000);
        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("-------------");
        list.clear();
        for (Person person : list) {
            System.out.println(person);
        }
    }
}