package com.javarush.task.task18.task1818;

import java.io.*;
/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ff = reader.readLine();
        String sf = reader.readLine();
        String tf = reader.readLine();
        FileOutputStream fOut = new FileOutputStream(ff);
        FileInputStream sReader = new FileInputStream(sf);
        FileInputStream tReader = new FileInputStream(tf);
        while (sReader.available() > 0) {
            fOut.write(sReader.read());
        }
        while (tReader.available() > 0) {
            fOut.write(tReader.read());
        }
        fOut.close();
        sReader.close();
        tReader.close();


    }
}
