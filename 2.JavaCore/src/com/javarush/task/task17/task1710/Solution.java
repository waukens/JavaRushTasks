package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static Person addPerson(String name, String sex, String bd) {
        Date date = new Date();
        try {
             date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
        } catch (ParseException e) {
        }
        if (sex.equals("м")) {
            return Person.createMale(name, date);
        } else {
            return Person.createFemale(name, date);
        }
    }

    public static void main(String[] args) throws ParseException{
        switch (args[0]) {
            case "-c": {
                Person p = addPerson(args[1], args[2], args[3]);
                allPeople.add(p);
                System.out.println(allPeople.indexOf(p));
                break;
            }
            case "-u": {
                allPeople.set(Integer.parseInt(args[1]), addPerson(args[2], args[3], args[4]));
                break;
            }
            case "-d": {
                Person p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(null);
                p.setSex(null);
                p.setBirthDay(null);
                allPeople.set(Integer.parseInt(args[1]), p);
                break;
            }
            case "-i": {
                Person p = allPeople.get(Integer.parseInt(args[1]));
                String sex = null;
                if (p.getSex() == Sex.FEMALE) {
                    sex = "ж";
                } else {
                    sex = "м";
                }
                System.out.println(p.getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
                break;
            }
        }
    }
}