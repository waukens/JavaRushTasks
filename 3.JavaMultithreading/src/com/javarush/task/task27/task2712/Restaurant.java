package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    final int number;

    public Restaurant(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Cook amigo = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        Waiter waiter = new Waiter();
        tablet.addObserver(amigo);
        amigo.addObserver(waiter);
        Order order = tablet.createOrder();
    }
}
