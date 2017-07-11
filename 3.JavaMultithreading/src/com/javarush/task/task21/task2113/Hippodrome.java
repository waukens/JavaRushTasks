package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noname on 11.07.17.
 */
public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double distance = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > distance) {
                distance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        Horse annHorse = new Horse("Anna", 3, 0);
        Horse tomHorse = new Horse("Tom", 3, 0);
        Horse nicHorse = new Horse("Nic", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(annHorse);
        horses.add(tomHorse);
        horses.add(nicHorse);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
}
