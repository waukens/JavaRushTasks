package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static Person newPerson(String name, String sex, String date) {
        synchronized (allPeople) {
            Date bd = new Date();
            try {
                bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
            } catch (ParseException e) {
            }
            if (sex.equals("м")) {
                return Person.createMale(name, bd);
            } else {
                return Person.createFemale(name, bd);
            }
        }
    }

    public static void main(String[] args) {
       if (args.length > 0) {
           switch (args[0]) {
               case "-c":
                   synchronized (allPeople) {
                       for (int i = 0; i < (args.length - 1) / 3; i++) {
                           Person p = newPerson(args[i * 3 + 1], args[i * 3 + 2], args[i * 3 + 3]);
                           allPeople.add(p);
                           System.out.println(allPeople.indexOf(p));
                       }
                       break;
                   }
               case "-u":
                   synchronized (allPeople) {
                       for (int i = 0; i < (args.length - 1) / 4; i++) {
                           allPeople.set(Integer.parseInt(args[i * 4 + 1]), newPerson(args[i * 4 + 2], args[i * 4 + 3], args[i * 4 + 4]));
                       }
                       break;
                   }

               case "-d":
                   synchronized (allPeople) {
                       for (int i = 1; i < args.length; i++) {
                           Person p = allPeople.get(Integer.parseInt(args[i]));
                           p.setName(null);
                           p.setSex(null);
                           p.setBirthDay(null);
                           allPeople.set(Integer.parseInt(args[i]), p);
                       }
                       break;
                   }
               case "-i":
                   synchronized (allPeople) {
                       for (int i = 1; i < args.length; i++) {
                           Person p = allPeople.get(Integer.parseInt(args[i]));
                           String sex = null;
                           if (p.getSex().equals(Sex.FEMALE)) {
                               sex = "ж";
                           } else {
                               sex = "м";
                           }
                           System.out.println(p.getName() + " " + sex + " " +
                                   new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));


                       }
                   }
           }
       }
    }
}
