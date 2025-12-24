Spring Dependency Injection Demo

This project demonstrates Dependency Injection (DI) using Spring Core (XML-based configuration).

It shows how Spring achieves loose coupling by injecting dependencies into a dependent class using constructor injection, instead of creating objects with new.

Key Concepts

Spring IoC Container

Dependency Injection

Constructor Injection

Loose Coupling

XML Configuration (beans.xml)

Technologies

Java

Spring Core

Summary

Spring creates and manages all objects, injects required dependencies at runtime, and returns a fully initialized bean to the application.


*************************************************************
Execution Flow of the Program
*************************************************************

1️⃣ main() starts

📍 Happens here

public static void main(String[] args) {


📌 Meaning
Normal Java program entry point.
Spring is NOT involved yet.

2️⃣ Spring container starts

📍 Happens here

ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("beans.xml");


📌 Under the hood

JVM creates Spring IoC Container

Container lifecycle begins

📝 Note to write

Spring container is created when ApplicationContext is instantiated.

3️⃣ beans.xml is read

📍 Triggered by same line

new ClassPathXmlApplicationContext("beans.xml");


📌 Under the hood

Spring locates beans.xml in classpath

Parses XML

Registers bean definitions internally

📝 Mark

Bean definitions are loaded from beans.xml during container initialization.

4️⃣ ContactInfo object created

📍 Happens here (inside container, not your code)

<bean id="contact"
      class="com.jspiders.springs.demo.ContactInfo"/>


📌 When exactly?

At container startup

Because default scope = singleton

📝 Important note

Dependency objects are created before dependent objects.

5️⃣ Address object created

📍 Happens here

<bean id="address"
      class="com.jspiders.springs.demo.Address"/>


📌 Same timing

During container startup

Stored inside IoC container

6️⃣ Employee object created with injected dependencies

📍 Defined here

<bean id="employee"
      class="com.jspiders.springs.demo.Employee">

    <constructor-arg ref="contact"/>
    <constructor-arg ref="address"/>
</bean>


📌 Under the hood
Spring does:

new Employee(contactObj, addressObj);


📝 Key interview note

Spring resolves constructor arguments and injects dependencies before object creation completes.

7️⃣ getBean("employee") called

📍 Happens here

Employee emp = context.getBean("employee", Employee.class);


📌 What happens

Container looks up employee bean

Returns already created singleton instance

📝 Important

No new object is created here (default scope).

8️⃣ Fully wired Employee returned

📍 Same line result

Employee emp = context.getBean("employee", Employee.class);


📌 State of object

contact ≠ null

address ≠ null

Fully injected

📝 Final note

Spring returns a fully initialized and dependency-injected object.

🧠 One-Box Summary (Perfect for Notes)
main()
→ ApplicationContext created
→ beans.xml parsed
→ Bean definitions registered
→ Dependencies instantiated
→ Dependent beans instantiated with DI
→ getBean() returns ready-to-use object
