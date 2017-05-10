package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileReader;
/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);
        BufferedReader bReader = new BufferedReader(fReader);
        Map<String, Double> salaryMap = new TreeMap<>();
        String line;
        String key;
        double value;

        while ((line = bReader.readLine()) != null) {
            key = line.split(" ")[0];
            value = Double.parseDouble(line.split(" ")[1]);
            if (salaryMap.containsKey(key)) {
                salaryMap.put(key, salaryMap.get(key) + value);
            } else {
                salaryMap.put(key, value);
            }
        }

        fReader.close();
        double maxValue = Double.MIN_VALUE;
        for (double currValue : salaryMap.values()) {
            if (currValue > maxValue) {
                maxValue = currValue;
            }
        }
        for (String s : salaryMap.keySet()) {
            if (salaryMap.get(s) == maxValue) {
                System.out.println(s);
            }
        }
    }
}
