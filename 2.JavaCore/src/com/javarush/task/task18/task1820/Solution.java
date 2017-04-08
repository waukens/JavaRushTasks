package com.javarush.task.task18.task1820;

import java.io.*;


/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ff = reader.readLine();
        String sf = reader.readLine();
        FileInputStream fi = new FileInputStream(ff);
        FileOutputStream fo = new FileOutputStream(sf);
        StringBuffer sb = new StringBuffer();
        while (fi.available() > 0) {
            sb.append((char)fi.read());
        }
        String[] ch = sb.toString().split(" ");
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
            int numI = Math.round(Float.parseFloat(ch[i]));
            fo.write(Integer.toString(numI).getBytes());
            fo.write(32);
        }
        fi.close();
        fo.close();
        reader.close();

    }
}
