package com.javarush.task.task18.task1827;

/* 
Прайсы
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String productName = args[1];
//        String price = args[2];
//        String quatity = args[3];
        int id = 0;
        RandomAccessFile ra = new RandomAccessFile(fileName, "rw");
        if (ra.length() >= 80) {
            ra.seek(ra.length() - 80);
            byte[] buffer = new byte[8];
            id = ra.read(buffer, 0, 8);
        }
        System.out.println(id);



    }
}
