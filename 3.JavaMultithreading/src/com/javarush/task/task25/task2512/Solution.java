package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printException(e);
    }

    private void printException(Throwable e) {
        if (e.getCause() != null) {
            printException(e.getCause());
        }
        System.out.println(e);
    }


    public static void main(String[] args) throws Exception {

    }

}