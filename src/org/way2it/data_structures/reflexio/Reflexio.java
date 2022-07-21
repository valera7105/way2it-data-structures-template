package org.way2it.data_structures.reflexio;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflexio {

    public static void main(String[] args) {
        Person valerii = new Person("Valerii", 51);
        if (valerii!=null) {
            valerii.printInfo();
            Class classes=valerii.getClass();
            if (classes!=null) {
                listmetod(classes);
                listfield(classes);
                listconructor(classes);
            }
        }
        Person nataliya=new Person("Nataliya");
        nataliya.printInfo();

        Person olena=new Person();
        olena.printInfo();
    }

    public static void listmetod(Class classes) {
        System.out.println("listmetod");
        Method [] methods= classes.getMethods();
        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }
    }


    public static void listfield(Class classes) {
        System.out.println("listfield");
        Field[] fields= classes.getFields();
        for(Field field : fields ){
            System.out.println("fields = " + field.getName());
        }
    }

    public static void listconructor(Class classes) {
        System.out.println("listconructor");
        Constructor [] constructors=classes.getConstructors();
        for(Constructor constructor : constructors ){
            System.out.println("constructor = " + constructor.getName());
        }
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public Person(String name) {
        new Person(name,18);
    }

    public Person() {
        new Person("Olena");
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Name: " + getName()+ "  Age: "+getAge());
    }
}