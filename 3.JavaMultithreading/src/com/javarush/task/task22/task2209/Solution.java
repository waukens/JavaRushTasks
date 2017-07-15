package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(reader.readLine())));
        ) {
            StringBuilder sb = new StringBuilder();
            while (fileReader.ready()) {
                sb.append(fileReader.readLine());
            }
            String[] words = sb.toString().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words != null && words.length != 0) {
            List<String> listOfWords = new ArrayList<>(Arrays.asList(words));
            listOfWords.sort(Comparator.naturalOrder());
            sb.append(listOfWords.get(0));
            listOfWords.remove(0);
            String currentValue = null;
            for (int i = 0; i < words.length; i++) {
                Iterator<String> iter = listOfWords.iterator();
                while (iter.hasNext()) {
                    currentValue = iter.next();
                    if (currentValue.toLowerCase().charAt(0) == sb.charAt(sb.length() - 1)) {
                        sb.append(" " + currentValue);
                        iter.remove();
                    }
                }
            }
            for (String s : listOfWords) {
                sb.append(" " + s);
            }
            return  sb;
        } else {
            return sb;
        }
    }
}
