package com.javarush.task.task18.task1823;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = "";
        ArrayList<String> fileNames = new ArrayList<>();
        while (true) {
            fName = reader.readLine();
            if (fName.equals("exit")) {
                break;
            } else {
                fileNames.add(fName);
            }
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
