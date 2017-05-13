package com.javarush.task.task18.task1827;

/* 
Прайсы
*/
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> indexs = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        if (args[0].equals("-c")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length - 2; i++) {
                sb.append(args[i]);
                sb.append(" ");
            }
            String productName = sb.toString();
            String price = args[args.length - 2];
            String quatity = args[args.length - 1];
            BufferedReader fBR = new BufferedReader(new FileReader(fileName));
            Pattern p = Pattern.compile("[0-9]+");
            while (fBR.ready()) {
                String line = fBR.readLine();
                lines.add(line);
                System.out.println(line);
//                Matcher mstch = p.matcher(line);
//                mstch.find();
//                indexs.add(Integer.parseInt(match.group(0)));
            }
            for (int i : indexs) {
                System.out.println(i);
            }

//            String lastLine = String.format("%-8d%-30.30s%-8.8s%-4.4s", nextInd, productName, price, quatity);
//            FileOutputStream fo = new FileOutputStream(fileName);
//            for (int i = 0; i < data.size(); i++) {
//                fo.write(data.get(i));
//            }
//            fo.write(13);
//            fo.write(10);
//            fo.write(lastLine.getBytes());
//            fo.write(13);
//            fo.write(10);
//            fo.close();
        }
    }
}