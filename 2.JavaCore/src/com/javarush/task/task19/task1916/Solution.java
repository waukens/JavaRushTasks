package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();
        FileReader firstFileReader = new FileReader(firstFileName);
        BufferedReader firstBR = new BufferedReader(firstFileReader);

        FileReader secondFileReader = new FileReader(secondFileName);
        BufferedReader secondBR = new BufferedReader(secondFileReader);

        ArrayList<String> firstArray = new ArrayList<>();
        ArrayList<String> secondArray = new ArrayList<>();

        while (firstBR.ready()) {
            firstArray.add(firstBR.readLine());
        }

        while (secondBR.ready()) {
            secondArray.add(secondBR.readLine());
        }
        firstFileReader.close();
        secondFileReader.close();

        for (String s : firstArray) {
            String firstValueToCheck = null;
            String secondValueToCheck = null;
            if (secondArray.size() == 1) {
                firstValueToCheck = secondArray.get(0);
            } else if (secondArray.size() > 1) {
                firstValueToCheck = secondArray.get(0);
                secondValueToCheck = secondArray.get(1);
            }
            if (s.equals(firstValueToCheck)) {
                lines.add(new LineItem(Type.SAME, s));
                secondArray.remove(0);
            } else if (s.equals(secondValueToCheck)) {
                lines.add(new LineItem(Type.ADDED, firstValueToCheck));
                lines.add(new LineItem(Type.SAME, s));
                secondArray.remove(0);
                secondArray.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }
        for (String s : secondArray) {
            lines.add(new LineItem(Type.ADDED, s));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
