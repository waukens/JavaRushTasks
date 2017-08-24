package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        class myUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public void uncaughtException(Thread t, Throwable e) {
                String newName = new String(new char[t.getName().length()]).replace("\0", "*");
                String newMessage = e.getMessage().replace(t.getName(), newName);
                System.out.println(newMessage);
            }
        }    //init handler here
        handler = new myUncaughtExceptionHandler();
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });
        solution.run();
    }
}