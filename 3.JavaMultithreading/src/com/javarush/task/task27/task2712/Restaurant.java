package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    final int number;

    public Restaurant(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Cook amigo = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(amigo);
        tablet.createOrder();
    }
}
