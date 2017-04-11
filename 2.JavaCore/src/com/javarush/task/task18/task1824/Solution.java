package com.javarush.task.task18.task1824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* 
Файлы и исключения
*/

public class Solution {
    public static FileInputStream fi;
    public static void main(String[] args) throws IOException {
        String s = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                s = reader.readLine();
                fi = new FileInputStream(s);
                fi.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(s);
        }
    }

}
