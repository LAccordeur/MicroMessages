package com.guoyang.test;

/**
 * Created by L'Accordeur on 2016/10/13.
 */
public class test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("test");
        student.test();
    }
}


class Person {
    public Person() {
        System.out.println("This is a person");
    }
    public Person(String name) {
        System.out.println("This has a name " + name);
    }
}

class Student {
    Person person = new Person();

    public void test() {
        Person person = new Person("test");
        System.out.println("test");
    }


}