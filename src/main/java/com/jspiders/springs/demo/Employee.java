package com.jspiders.springs.demo;

public class Employee {
    private int id;
    private String name;
    private double salary;

    ContactInfo contact;

    Address address;

    //Injecting dependency in Constructor
    //here we are not creating the object of contatcinfo class directly instead we are doing it in mainclass using springs
    public Employee(ContactInfo contact , Address address){
        this.contact=contact;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
