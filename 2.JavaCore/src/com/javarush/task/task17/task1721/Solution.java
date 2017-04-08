package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFile = reader.readLine();
            BufferedReader fr = new BufferedReader(new FileReader(firstFile));
            String line = null;
            while ((line = fr.readLine()) != null) {
                allLines.add(line);
            }
            fr.close();
            String secondFile = reader.readLine();
            BufferedReader fsr = new BufferedReader(new FileReader(secondFile));
            while ((line = fsr.readLine()) != null) {
                forRemoveLines.add(line);
            }
            fsr.close();
            Solution sol = new Solution();
            sol.joinData();
        } catch (IOException e) {}
    }

    public void joinData () throws CorruptedDataException {
        int index = 0;
        for (String s : forRemoveLines) {
            if ((index = allLines.indexOf(s)) != -1) {
                allLines.remove(index);
            } else {
                allLines = new ArrayList<>();
                throw new CorruptedDataException();
            }
        }

    }
}
