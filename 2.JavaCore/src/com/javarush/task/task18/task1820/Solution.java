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
        String s = null;
        while ((s = fi.readLine()) != null) {
            double numD = Double.parseDouble(s);
            int numI = (int)numD;
            int znak = 1;
            if (numD < 0) {
                znak = -1;
            }
            if (numD % numI * znak >= 0.5) {
                int num = numI + znak;
                sb.append(num + " ");
            } else {
                sb.append(numI + " ");
            }
        }
        fo.write(sb.toString().getBytes());
        fi.close();
        fo.close();
        reader.close();

    }
}
