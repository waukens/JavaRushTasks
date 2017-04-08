package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        int answer = a + b;
        return answer;
    }

    public static int minus(int a, int b) {
        int answer = a - b;
        return answer;
    }

    public static int multiply(int a, int b) {
        int answer = a * b;
        return answer;
    }

    public static double division(int a, int b) {
        double answer = (double)a / b;
        return answer;
    }

    public static double percent(int a, int b) {
        double answer = a * b / 100;
        return answer;
    }

    public static void main(String[] args) {

    }
}