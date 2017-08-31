package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double mediana;
        int size = array.length;
        if (size % 2 == 0) {
            mediana = (array[size / 2 - 1] + array[size / 2]) /2;
        } else {
            mediana = array[size / 2];
        }
        Arrays.sort(array, (o1, o2) -> Double.compare(Math.abs(o1-mediana), Math.abs(o2-mediana)));
        return array;
    }
}
