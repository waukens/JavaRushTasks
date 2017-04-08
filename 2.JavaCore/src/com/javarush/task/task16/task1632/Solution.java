package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));

    }
    public static void main(String[] args) {
    }

    public static class Thread1 implements Runnable {
        public void run() {
            while (true) {}
        }
    }
    public static class Thread2 implements Runnable {
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        }
    }
    public static class Thread4 extends Thread implements Message {
        public void showWarning() {
            this.interrupt();
        }
        public void run() {
            super.run();
        }
    }
    public static class Thread5 implements Runnable {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            int sum = 0;
            while (true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {}
                if (s.equals("N")) {
                    System.out.println(sum);
                    break;
                } else {
                    try {
                        sum += Integer.parseInt(s);
                    } catch (IllegalFormatException e) {}
                }
            }
        }



    }
}
