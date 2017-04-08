package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[15];
        try {
            for (int i = 0; i < houses.length; i++) {
                houses[i] = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e){
            System.out.println("Oops!");
        }
        int even = houses[0];
        int odd = 0;
        for (int i = 1; i < houses.length; i += 2) {
            even += houses[i + 1];
            odd += houses[i];
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше житедей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
