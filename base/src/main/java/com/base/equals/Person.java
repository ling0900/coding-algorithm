package com.base.equals;

import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    // 没有重写 hashCode()

    //----------
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);

        // 输出：true，equals 方法判断为相等
        System.out.println(person1.equals(person2));

        // 放入 HashSet
        HashSet<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);

        System.out.println(person1.hashCode() + " " + person2.hashCode());

        // 实际上两个对象是相等的，但是 HashSet 会认为它们是不同的对象
        // 因为 hashCode 没有重写，默认的 Object.hashCode() 返回的是对象内存地址的散列值
        System.out.println(set.size());  // 输出：2
    }
}
