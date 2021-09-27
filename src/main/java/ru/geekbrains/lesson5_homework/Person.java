package ru.geekbrains.lesson5_homework;


public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Person() {
        fullName = "someName";
        position = "somePosition";
        email = "someEmail";
        phoneNumber = "somePhoneNumber";
        salary = 0;
        age = 0;
    }
public Person(String fullName, String position, String email, String phoneNumber, int salary, int age) {
    this.fullName = fullName;
    this.position = position;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.salary = salary;
    this.age = age;
}

public void printEmployee() {
    System.out.println(fullName + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
}
public int getAge() {
    return age;

}

}
