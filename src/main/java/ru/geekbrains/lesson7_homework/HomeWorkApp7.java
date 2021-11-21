package ru.geekbrains.lesson7_homework;


public class HomeWorkApp7 {

    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Мурзик", 20);
        cat[1] = new Cat("Барсик", 15);
        cat[2] = new Cat("Кот", 5);
        cat[3] = new Cat("Рыжик", 35);
        cat[4] = new Cat("Горбатый", 50);
        Plate plate = new Plate(30);
        plate.info();
        for (Cat value : cat) {
            value.eat(plate);
            plate.info();
            if (!value.isSatiety()) {
                System.out.println("Добавим еду в тарелку");
                plate.addFood(60);
                value.eat(plate);
                plate.info();
            }
        }


    }
}
