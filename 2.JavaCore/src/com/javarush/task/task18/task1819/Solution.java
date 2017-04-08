package com.javarush.task.task18.task1819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        String ff = reader.readLine();
        String sf = reader.readLine();
        FileInputStream ffI= new FileInputStream(ff);
        while (ffI.available() > 0) {
            arr.add(ffI.read());
        }
        ffI.close();
        FileInputStream ffS = new FileInputStream(sf);
        FileOutputStream ffO = new FileOutputStream(ff);
        while (ffS.available() > 0) {
            ffO.write(ffS.read());
        }
        for (int i : arr) {
            ffO.write(i);
        }

        ffS.close();
        ffO.close();

    }
}
