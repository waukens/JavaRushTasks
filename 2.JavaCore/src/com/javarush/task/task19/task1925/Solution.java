package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        String firstFileName = args[0];
        String secondFileName = args[1];
        FileReader fReader = new FileReader(firstFileName);
        BufferedReader bReader = new BufferedReader(fReader);
        FileWriter fWriter = new FileWriter(secondFileName);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[^ ]{7,}");
        while (bReader.ready()) {
            String line = bReader.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                sb.append(matcher.group());
                sb.append(",");
            }
        }
        fReader.close();
        String newLine = sb.toString();
        newLine = newLine.substring(0, newLine.length() - 1);
        fWriter.write(newLine);
        fWriter.close();
    }
}
