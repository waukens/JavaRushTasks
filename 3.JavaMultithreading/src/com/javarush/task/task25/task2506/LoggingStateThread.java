package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Enum state = thread.getState();
        Enum newState;
        System.out.println(state);
        while (state != State.TERMINATED) {
            if ((newState = thread.getState()) != state) {
                System.out.println(newState);
                state = newState;
            }
        }
        this.interrupt();
    }
}
