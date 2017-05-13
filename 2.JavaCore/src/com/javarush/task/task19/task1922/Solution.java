package com.javarush.task.task19.task1922;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bReader.readLine();
        bReader.close();
        FileReader fReader = new FileReader(fileName);
        BufferedReader bfReader = new BufferedReader(fReader);
        String line;
        while ((line = bfReader.readLine()) != null) {
            String[] s = line.split(" ");
            int count = 0;
            for (String readLine : s) {
                for (String word : words) {
                    if (word.equals(readLine)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        fReader.close();
    }
}
