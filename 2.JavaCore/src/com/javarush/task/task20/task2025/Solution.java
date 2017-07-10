package com.javarush.task.task20.task2025;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/* 
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        int count = 0;
        long num = N;
        while (num / 10 > 0) {
            count++;
            num /= 10;
        }
        List<Long> armsList = new ArrayList<>();
        armsList = ArmstrongNumbersMultiSetLongOpt.generate(count + 1);
        Iterator<Long> iter = armsList.iterator();
        while (iter.hasNext()) {
            if (iter.next() >= Math.pow(10, count)) {
                iter.remove();
            }
        }
        long[] result = new long[armsList.size()];
        for (int i = 0; i < armsList.size(); i++) {
            result[i] = armsList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Date start = new Date();
        long[] result = getNumbers(1000);
        for (long l : result) {
            System.out.println(l);
        }
        long duration = new Date().getTime() - start.getTime();
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("time " + duration + " memory " + usedBytes);
    }
}

class ArmstrongNumbersMultiSetLongOpt {
    private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    private static long[][] pows;

    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }

    public static List<Long> generate(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }

        return results;
    }
}
