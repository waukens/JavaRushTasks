package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < 10; i++)
                list.add(reader.readLine());
        } catch (IOException e) {
            System.out.println("Oops");
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int indMax = 0;
        int indMin = 0;
        for (int i= 0; i < 10; i++) {
            int temp = list.get(i).length();
            if (min > temp) {
                min = temp;
                indMin = i;
            }
            if (max < temp) {
                max = temp;
                indMax = i;
            }
        }
        if (indMax < indMin) {
            System.out.println(list.get(indMax));
        } else {
            System.out.println(list.get(indMin));
        }
    }
}
