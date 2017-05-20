package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fReader = new FileReader(fileName);
        BufferedReader bReader = new BufferedReader(fReader);
        while (bReader.ready()) {
            String line = bReader.readLine();
            for (int i = line.length() - 1; i >= 0; i--) {
                System.out.print(line.charAt(i));
            }
            System.out.println("");
        }
        fReader.close();

    }
}
