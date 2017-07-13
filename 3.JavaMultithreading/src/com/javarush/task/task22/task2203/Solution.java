package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) {
            throw new TooShortStringException();
        } else {
            int start = string.indexOf("\t");
            int end = string.indexOf("\t", start + 1);
            if (start == -1 || end == -1) throw new TooShortStringException();
            System.out.println(start + " " + end);
            return string.substring(start + 1, end);
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java.\t"));
        System.out.println(getPartOfString(null));
    }
}
