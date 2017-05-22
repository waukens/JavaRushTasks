package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream arrayToOut = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(arrayToOut);
        System.setOut(myOut);
        testString.printSomething();
        System.setOut(console);
        String[] words = arrayToOut.toString().split("\n");
        for (int i = 0 ; i < words.length; i++) {
            if (i % 2 == 0 && i != 0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(words[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
