package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        Dish[] allDishes = Dish.values();
        StringBuffer sb = new StringBuffer();
        for (Dish dish : allDishes)
            sb.append(dish + " ");
        return sb.toString().replaceAll("\\s+$", "");
    }
}
