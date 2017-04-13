package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String crypt = args[0];
        String fileName = args[1];
        String fileOutPutName = args[2];
        FileInputStream fi = new FileInputStream(fileName);
        FileOutputStream fo = new FileOutputStream(fileOutPutName);
        int solt = 0;
        if (crypt.equals("-e")) {
            solt = 1;
        } else {
            solt = -1;
        }
        while (fi.available() > 0) {
            fo.write(fi.read() + solt);
        }
        fi.close();
        fo.close();

    }

}
