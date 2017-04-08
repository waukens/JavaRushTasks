package com.javarush.task.task18.task1817;

import java.io.*;
/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length > 0) {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
            int count = dis.available();
            float spaceCount = 0f;
            int simbol = 0;
            while (dis.available() > 0) {
                simbol = dis.read();
                if ((simbol) == 32) {
                    spaceCount++;
                }
            }
            System.out.format("%.2f", spaceCount / count * 100);
            dis.close();
        } else {

        }


    }
}
