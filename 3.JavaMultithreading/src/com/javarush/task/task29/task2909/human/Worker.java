package com.javarush.task.task29.task2909.human;

public class Worker {
    private Human human;
    private Soldier soldier;
    private double salary;
    public String company;

    public Worker(String name, int age) {
        human = new Human(name, age);
    }

    public void live() {
        soldier.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}