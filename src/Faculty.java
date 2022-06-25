/*
 * Programmed by Saravana Polisetti
 *
 * Description: This program shows the idea of a constructor chaining.
 * The Faculty class extends to the Employee class, and the Employee
 * class extends to the Person class. Now before Faculty can call its
 * constructor, there is an implicit super(), which calls the parent
 * class constructor, which in this case is Employee. But before Employee
 * can call its constructors, there is an implicit super(), which calls the
 * parent class constructor, which is Person. This means that the current
 * class is able to call its constructors only after the super class
 * constructors have been called. This is why we get the output below.
 */
public class Faculty extends Employee{
    public static void main(String[] args) {
        new Faculty();
    }

    public Faculty() {
        System.out.println("(4) Faculty's no-arg constructor is invoked.");
    }
}

class Employee extends Person {
    public Employee() {
        this("(2) Invoke Employee's overloaded constructor");
        System.out.println("(3) Employee's no-arg constructor is invoked.");
    }

    public Employee(String s) {
        System.out.println(s);
    }
}

class Person {
    public Person() {
        System.out.println("(1) Person's no-arg constructor is invoked.");
    }
}

/* Program Output:
(1) Person's no-arg constructor is invoked.
(2) Invoke Employee's overloaded constructor
(3) Employee's no-arg constructor is invoked.
(4) Faculty's no-arg constructor is invoked.

 */