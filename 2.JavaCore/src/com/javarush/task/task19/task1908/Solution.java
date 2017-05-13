package com.javarush.task.task19.task1908;

import java.io.*;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        StringBuffer sb = new StringBuffer();
        while (fileReader.ready()) {
            sb.append((char)fileReader.read());
        }
        fileReader.close();
        String[] parts = sb.toString().split("\\s");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));
        for (String s : parts) {
            try {
                int i = Integer.parseInt(s);
                fileWriter.write(s);
                fileWriter.write(" ");
            } catch (NumberFormatException e) {

            }
        }
        fileWriter.close();
    }
}
