package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fReader = new FileReader(fileName);
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> startPos = new ArrayList<>();
        ArrayList<Integer> endPos = new ArrayList<>();
        while (fReader.ready()) {
            sb.append((char) fReader.read());
        }
        fReader.close();
        String line = sb.toString();
        String tag = args[0];
        String startTag = "<" + tag;
        String endTag = "</" + tag + ">";
        Pattern startP = Pattern.compile(startTag);
        Matcher startM = startP.matcher(line);
        while (startM.find()) {
            startPos.add(startM.start());
        }
        Pattern endP = Pattern.compile(endTag);
        Matcher endM = endP.matcher(line);
        while (endM.find()) {
            endPos.add(endM.end());
        }

        int num = 0;
        for (int i = 0; i < startPos.size() - 1; i++) {
            int sum = 0;
            Iterator<Integer> iter = endPos.iterator();
            while (iter.hasNext()) {
                if ((num = iter.next()) <= startPos.get(i + 1)) {
                    System.out.println(line.substring(startPos.get(i), endPos.get(sum)));
                    iter.remove();
                    sum = 0;
                    break;
                } else {
                    sum++;
                    System.out.println(line.substring(startPos.get(i), endPos.get(sum)));
                    iter.next();
                    iter.remove();
                    break;
                }
            }
        }
        if (!endPos.isEmpty()) {
            System.out.println(line.substring(startPos.get(startPos.size() - 1), endPos.get(0)));
        }
    }
}
