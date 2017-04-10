package com.javarush.task.task18.task1823;

import javax.print.DocFlavor;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
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
        for (String name : fileNames) {
            new ReadThread(name).start();
        }
        for (String key : resultMap.keySet()) {
            System.out.println(key + " " + resultMap.get(key));
        }

    }

    public static class ReadThread extends Thread {
        private String fileN;
        public ReadThread(String fileName) {
            super(fileName);
            fileN = fileName;
        }
        public void run() {
            try {
                FileInputStream fi = new FileInputStream(fileN);
                int[] arr = new int[256];
                while (fi.available() > 0) {
                    int i = fi.read();
                    arr[i] = arr[i] + 1;
                }
                fi.close();
                int max = Integer.MIN_VALUE;
                int ind = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i]  > max) {
                        max = arr[i];
                        ind = i;
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileN, ind);
                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
    }
}
