package com.base01.listset;

import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList();

        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(2));
        l.add(Integer.valueOf(1));
        //l.forEach(System.out::println);
        l.remove(Integer.valueOf(1));
        l.forEach(System.out::println);
    }
}
