package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> parts = new TreeSet<>();
        String line = "";
        while (!(line = reader.readLine()).equals("end")) {
            parts.add(line);
        }
        Iterator<String> iter = parts.iterator();
        String mainFile = iter.next();
        mainFile = mainFile.substring(0, mainFile.lastIndexOf("."));
        FileOutputStream fo = new FileOutputStream(mainFile);
        for (String s : parts) {
            FileInputStream fi = new FileInputStream(s);
            byte[] buffer = new byte[fi.available()];
            while (fi.available() > 0) {
                int count = fi.read(buffer);
                fo.write(buffer, 0, count);
            }
            fi.close();
        }
        fo.close();
        reader.close();


    }
}
