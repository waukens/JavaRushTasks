package com.javarush.task.task25.task2514;

import sun.awt.windows.ThemeReader;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Runnable yel = new YieldRunnable(1);
        Thread th = new Thread(yel);
        Runnable yel2 = new YieldRunnable(2);
        Thread th2 = new Thread(yel2);
        th.start();
        th2.start();
    }
}
