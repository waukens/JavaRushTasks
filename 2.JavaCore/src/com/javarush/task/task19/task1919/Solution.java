package com.javarush.task.task19.task1919;

import java.util.Map;
import java.util.TreeMap;
import java.io.FileReader;
/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);
        Map<String, Double> salary = new TreeMap<>();
        StringBuffer sb = new StringBuffer();
        while (fReader.ready()) {
            sb.append((char)fReader.read());
        }
        fReader.close();
        String[] lines = sb.toString().split("\\s");
        for (int i = 0; i < lines.length; i = i + 2) {
            if (salary.containsKey(lines[i])) {
                salary.put(lines[i], salary.get(lines[i]) + Double.parseDouble(lines[i + 1]));
            } else {
                salary.put(lines[i], Double.parseDouble(lines[i + 1]));
            }
        }
        for (Map.Entry<String, Double> entry : salary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
