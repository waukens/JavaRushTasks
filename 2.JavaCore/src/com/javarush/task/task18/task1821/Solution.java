package com.javarush.task.task18.task1821;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String file = args[0];
        FileInputStream fi = new FileInputStream(file);
        int[] arr = new int[256];
        while (fi.available() > 0) {
            int num = fi.read();
            arr[num] = arr[num] + 1;
        }
        fi.close();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.println((char)i + " " + arr[i]);
            }
        }


    }
}
