package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        return line;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> dishes = new ArrayList<>();
        Boolean openingOrder = true;
        writeMessage(Dish.allDishesToString());
        Dish[] allDishes = Dish.values();
        writeMessage("What would you like? ");
        while (openingOrder) {
            String dish = readString();
            if (dish.equals("exit")) {
                openingOrder = false;
                break;
            }
            Boolean isDishPresent = false;
            for (Dish dishToCheck : allDishes) {
                if (dishToCheck.toString().equals(dish)) {
                    dishes.add(dishToCheck);
                    isDishPresent = true;
                    break;
                }
            }
            if (!isDishPresent) {
                writeMessage("There aren't such a dish, please try one more time ");
            }
        }
        return dishes;
    }

    public static void main(String[] args) {
        ConsoleHelper cs = new ConsoleHelper();
        try {
            List<Dish> list = cs.getAllDishesForOrder();
            for (Dish d : list) {
                System.out.println(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
