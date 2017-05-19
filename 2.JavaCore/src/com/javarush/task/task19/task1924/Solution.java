package com.javarush.task.task19.task1924;

import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fReader = new FileReader(fileName);
        BufferedReader bReader = new BufferedReader(fReader);
        while (bReader.ready()) {
            String line = bReader.readLine();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                line = line.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
            }
            System.out.println(line);
        }
        fReader.close();
    }
}
