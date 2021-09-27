package ru.geekbrains.lesson5_homework;

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray [0] = new Person("someName", "somePosition", "someEmail", "somePhoneNumber", 30000, 20 );
        persArray [1] = new Person("someName2", "somePosition", "someEmail", "somePhoneNumber", 40000, 48 );
        persArray [2] = new Person("someName3", "somePosition", "someEmail", "somePhoneNumber", 25000, 25 );
        persArray [3] = new Person("someName4", "somePosition", "someEmail", "somePhoneNumber", 35000, 42 );
        persArray [4] = new Person("someName5", "somePosition", "someEmail", "somePhoneNumber", 30000, 30 );

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printEmployee();
            }

        }
    }
}
