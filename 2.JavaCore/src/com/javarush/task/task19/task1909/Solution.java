package com.javarush.task.task19.task1909;


import java.io.*;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = "";
        String sName = "";
        try {
            fName = reader.readLine();
            sName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("oops");
        }

        try {
            BufferedReader fR = new BufferedReader(new FileReader(fName));
            BufferedWriter fW = new BufferedWriter(new FileWriter(sName));
            int symbol = 0;
            while (fR.ready()) {
                symbol = fR.read();
                if (symbol == 46) {
                    fW.write(33);
                } else {
                    fW.write(symbol);
                }
            }
            fR.close();
            fW.close();

        } catch (FileNotFoundException e) {
            System.out.println("Oops");
        } catch (IOException e) {
            System.out.println("Oops");
        }
    }
}
