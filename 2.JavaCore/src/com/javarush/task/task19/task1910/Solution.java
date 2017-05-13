package com.javarush.task.task19.task1910;

import java.io.*;
/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        StringBuffer sb = new StringBuffer();
        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        fileReader.close();

        String text = sb.toString().replaceAll("\\p{Punct}", "");

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));
        fileWriter.write(text, 0, text.length());
        fileWriter.close();
    }
}
