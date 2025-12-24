package com.jspiders.springs.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");

        //Load the configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Sample s1 = context.getBean("Sample",Sample.class);

        s1.showValue();
        s1.increment();
        s1.showValue();
        s1.decrement();
        s1.showValue();
        System.out.println("Program ends...");

    }
}