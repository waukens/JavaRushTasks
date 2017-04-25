package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            ArrayList<String> data = new ArrayList<>();

            while (fileScanner.hasNext()) {
                data.add(fileScanner.next());
            }

            Date date = new Date();
            date.setDate(Integer.parseInt(data.get(3)));
            date.setMonth(Integer.parseInt(data.get(4)));
            date.setYear(Integer.parseInt(data.get(5)));
            return new Person(data.get(1), data.get(2), data.get(0), date);
        }
    }
}
