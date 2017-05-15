package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        FileReader fReader = new FileReader(args[0]);
        BufferedReader bReader = new BufferedReader(fReader);
        String[] parts;
        String line;
        String name;
        Date bDate;
        while ((line = bReader.readLine()) != null) {
            parts = line.split(" ");
            int len = parts.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len - 3; i ++) {
                sb.append(parts[i]);
                sb.append(" ");
            }
            name = sb.deleteCharAt(sb.length() - 1).toString();
            bDate = new Date(Integer.parseInt(parts[len - 1]) - 1900, Integer.parseInt(parts[len - 2]) - 1,
                    Integer.parseInt(parts[len - 3]));
            PEOPLE.add(new Person(name, bDate));
        }
        fReader.close();



    }
}
