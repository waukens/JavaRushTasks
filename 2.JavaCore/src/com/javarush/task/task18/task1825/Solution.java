package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[10];
        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) {
                break;
            } else {
                String ind = "";
                for (int i = s.length() - 1; i > 0; i--) {
                    if (Character.isDigit(s.charAt(i))) {
                        ind = s.charAt(i) + ind;
                    }
                }
                arr[Integer.parseInt(ind)] = s;

            }
        }
        String fileName = arr[1].split(".")[0] + "." + arr[1].split(".")[1];
        FileOutputStream fo = new FileOutputStream(fileName);
        for (String s : arr) {
            if (s != null) {
                FileInputStream fi = new FileInputStream(s);
                byte[] buffer = new byte[1024];
                while (fi.available() > 0) {
                    int count = fi.read(buffer);
                    fo.write(buffer, 0, count);
                }
                fi.close();
            }

        }
        fo.close();
        reader.close();
    }
}
