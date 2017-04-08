package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file = args[0];
        FileInputStream iReader = new FileInputStream(file);
        int count = 0;
        int symbol = 0;
        while (iReader.available() > 0) {
            count = iReader.read();
            if ((count >= 65 && count <= 90) || (count >= 97 && count <= 122)) {
                symbol++;
            }
        }
        System.out.println(symbol);
        iReader.close();

    }
}
