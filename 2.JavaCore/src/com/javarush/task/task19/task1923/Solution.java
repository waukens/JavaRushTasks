package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.*;
/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String ffName = args[0];
        String sfName = args[1];
        FileReader fReader = new FileReader(ffName);
        FileWriter fWriter = new FileWriter(sfName);
        BufferedReader bReader = new BufferedReader(fReader);
        String line = null;
        Pattern pattern = Pattern.compile("\\d");
        while ((line = bReader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) {
                    fWriter.write(word);
                    fWriter.write(" ");
                }

            }
        }
        fReader.close();
        fWriter.close();
    }
}
