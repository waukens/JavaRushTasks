package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws Exception {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] parts = string.split(" ");
        StringBuilder sB = new StringBuilder();
        if (parts.length > 4) {
            for (int i = 1; i < 5; i++) {
                sB.append(parts[i] + " ");
            }
            return sB.toString().trim();
        } else {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
