package ru.geekbrains.lesson6_homework;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        int runLength = 300;
        int swimLength = 5;
        Cat cat = new Cat();
        Cat cat2 = new Cat(320, true, 10);
        Dog dog = new Dog();
        Dog dog2 = new Dog(400, false, 10);
        cat.animalRun(runLength);
        cat.animalSwim(swimLength);
        System.out.println();
        cat2.animalRun(runLength);
        cat2.animalSwim(swimLength);
        System.out.println();
        dog.animalRun(runLength);
        dog.animalSwim(swimLength);
        System.out.println();
        dog2.animalRun(runLength);
        dog2.animalSwim(swimLength);
        System.out.println();
        System.out.println("Создано " + Animal.count + " объекта");
    }
}
