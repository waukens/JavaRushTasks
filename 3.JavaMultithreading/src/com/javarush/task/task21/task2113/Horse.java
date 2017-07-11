package com.javarush.task.task21.task2113;

/**
 * Created by noname on 11.07.17.
 */
public class Horse {

    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance += speed * Math.random();
    }

    public void print() {

        System.out.println(new String(new char[(int)Math.floor(this.distance)]).replace("\0", ".") + getName());
    }
}
