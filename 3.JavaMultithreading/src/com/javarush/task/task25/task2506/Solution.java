package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}

class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Enum state = thread.getState();
        System.out.println(thread.getState());
        while (thread.getState() != State.TERMINATED) {
            if (state != thread.getState()) {
                System.out.println(thread.getState());
                state = thread.getState();
            }
        }
        System.out.println(thread.getState());
        this.interrupt();
    }
}
