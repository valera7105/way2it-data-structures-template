package org.way2it.data_structures.compar;

import netscape.security.PrivilegeTable;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

class Employee implements Serializable {
    private String name;
    private int id;
    private float salary;

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

}
    public class Compar {

    public static void main(String[] args) {
        Employee employee=new Employee();
        initemployee(employee);
        serialization(employee);
        deserialization(null);
        collectionserialization();
        collectiondeserialization();
    }

    public static void serialization(Object employee)  {
        try{
            FileOutputStream fout=new FileOutputStream("file.txt",true);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(employee);
            out.flush();
            out.close();
            fout.close();
            System.out.println("success serialization");
        } catch(Exception e) {
            System.out.println("error serialization - "+e);
        }
    }

    public static void deserialization(Employee dflt)  {
        try{
            Employee employee =null;
            if (dflt==null) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
                employee = (Employee) in.readObject();
                in.close();
            } else {
                employee =dflt;
            }
            System.out.println(employee.getId() + " " + employee.getName()+" "+ employee.getSalary());
            System.out.println("success deserialization");
        } catch(Exception e) {
            System.out.println("error deserialization - "+e);
        }
    }

    public  static void initemployee(Employee employee) {
        employee.setId(1);
        employee.setName("Nataliya");
        employee.setSalary(1000);
    }

    public static void collectionserialization(){
        ArrayList<Employee> employerlist = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) {
            Employee employee=new Employee();
            initemployee(employee);
            employerlist.add(employee);
        }
        serialization(employerlist);
    }

    public static void collectiondeserialization(){
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("file.txt"));
            ArrayList<Employee> employerlist = new ArrayList<Employee>();
            employerlist = (ArrayList) in.readObject();

            for (int i = 0; i < employerlist.size(); i++) {
                Employee employee = (Employee) employerlist.get(i);
                deserialization(employee);
            }

            System.out.println("success collectiondeserialization");
        } catch(Exception e) {
            System.out.println("error deserialization - "+e);
        }
    }

}





