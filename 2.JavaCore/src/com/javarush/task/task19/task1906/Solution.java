package com.javarush.task.task19.task1906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* 
Четные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = "";
        String secondFile = "";
        try {
            firstFile = reader.readLine();
            secondFile = reader.readLine();
        } catch (IOException e) {
            System.out.println("ops");
        }
        FileReader fr = new FileReader(firstFile);
        FileWriter fw = new FileWriter(secondFile);
        int count = 1;
        while (fr.ready()) {
            if (count % 2 == 0) {
                fw.write(fr.read());
                count++;
            } else {
                fr.read();
                count++;
            }
        }
        reader.close();
        fr.close();
        fw.close();
    }
}
