package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int len = a.length;
        int hight = a[0].length;
        int currentValue = 0;
        int startI = 0;
        int startJ = 0;
        int endI = 0;
        int endJ = 0;
        int rectangleCount = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hight; j++) {
                int countVal = 0;
                if ((currentValue = a[i][j]) == 1) {
                    countVal = 1;
                    startI = endI = i;
                    startJ = endJ = j;
                    while (checkRight(a, currentValue, endI, endJ)) {
                        endJ++;
                    }
                    while (checkButtom(a, currentValue, endI, endJ)) {
                        endI++;
                    }
                    if (countVal == 1) {
                        rectangleCount++;
                        for (int t = startI; t <= endI; t++) {
                            for (int r = startJ; r <= endJ; r++) {
                                a[t][r] = 0;
                            }
                        }
                    }
                }
            }
        }

        return rectangleCount;
    }

    public static boolean checkRight(byte[][]a, int number, int i, int j) {
        if (a[0].length - 1 <= j) {
            return false;
        } else {
            return a[i][j + 1] == number;
        }
    }

    public static boolean checkButtom(byte[][] a, int number, int i, int j) {
        if (a.length - 1 <= i) {
            return false;
        } else {
            return a[i + 1][j] == number;
        }
    }
}
