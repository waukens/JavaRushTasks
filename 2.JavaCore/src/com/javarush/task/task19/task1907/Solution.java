package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.regex.Pattern;
/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fR = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        while (fR.ready()) {
            sb.append((char)fR.read());
        }
        fR.close();
        String[] worlds = sb.toString().split("\\W");
        int count = 0;
        for (String s : worlds) {
            if (s.equals("world")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
