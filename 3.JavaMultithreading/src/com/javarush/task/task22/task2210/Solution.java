package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {


    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer sT;
        try {
            sT= new StringTokenizer(query, delimiter);
            String[] words = new String[sT.countTokens()];
            for (int j = 0; j < words.length; j++) {
                words[j] = sT.nextToken();
            }
            return words;
        } catch (NullPointerException e) {
            String[] s = new String[0];
            return s;
        }

    }
}
