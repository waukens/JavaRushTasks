package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fi = new BufferedReader(new FileReader(fileName));
        String s = "";
        String id = args[0];
        while ((s = fi.readLine()) != null) {
            if (s.split(" ")[0].equals(id)) {
                System.out.println(s);
                break;
            }
        }
        fi.close();
        reader.close();
    }
}
