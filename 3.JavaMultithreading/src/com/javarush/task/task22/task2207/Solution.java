package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String fileName = reader.readLine();
       BufferedReader fReader = new BufferedReader(new FileReader(fileName));
       StringBuilder sb = new StringBuilder();
       while (fReader.ready()) {
           sb.append(fReader.readLine() + " ");
       }
       fReader.close();
       reader.close();
       String[] words = sb.toString().split(" ");
       for (int i = 0; i < words.length - 1; i++) {
           for (int j = i +1; j < words.length; j++) {
               String reverse = new StringBuilder(words[j]).reverse().toString();
               if (words[i].equals(reverse)) {
                   Pair p = new Pair();
                   p.first = words[i];
                   p.second = words[j];
                   result.add(p);
               }
           }
       }
       for (Pair p : result) {
           System.out.println(p);
       }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
