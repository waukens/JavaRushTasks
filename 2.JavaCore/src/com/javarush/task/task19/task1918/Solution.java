package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fReader = new FileReader(fileName);
        StringBuffer sb = new StringBuffer();
        while (fReader.ready()) {
            sb.append((char) fReader.read());
        }
        String line = sb.toString();
        System.out.println(line);
        String tag = args[0];
        String patLine = "(<" + tag + ">)(<"+tag+">)?(\r\n)?(</" + tag + ">)(.*(</" + tag + ">))?";
        System.out.println(patLine);
        Pattern p = Pattern.compile(patLine);
        Matcher match = p.matcher(line);
        System.out.println("Answer");
        while (match.find()) {
            System.out.println(match.group());
            System.out.println("group size" + match.group().length());
        }
    }
}
