package ru.geekbrains.lesson2_5_homework;

import java.util.Arrays;

public class HomeWorkApp2_5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
method1();
method2();

    }

    public static void method1() {
        float[] array = new float[size];
        Arrays.fill(array, 1);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - currentTime);
    }


    public static void method2() {
        float[] array = new float[size];
        Arrays.fill(array, 1);
        float[] array_one = new float[size];
        float[] array_two = new float[size];
        long currentTime = System.currentTimeMillis();
        System.arraycopy(array, 0, array_one, 0, h);
        System.arraycopy(array, h, array_two, 0, h);
        Thread thread_one = new Thread(() -> {
            for (int i = 0; i < array_one.length; i++) {
                array_one[i] = (float) (array_one[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread_two = new Thread(() -> {
            for (int i = 0; i < array_two.length; i++) {
                array_two[i] = (float) (array_two[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread_one.start();
        thread_two.start();
        System.arraycopy(array_one, 0, array, 0, h);
        System.arraycopy(array_two, 0, array, h, h);


        System.out.println(System.currentTimeMillis() - currentTime);
    }
}
