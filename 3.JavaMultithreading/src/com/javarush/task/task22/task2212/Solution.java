package com.javarush.task.task22.task2212;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null | telNumber == "") {
            return false;
        }
        Pattern p = Pattern.compile("(^[+]\\d{2})?(([(]\\d{3}[)])|(\\d{3,6})){1}((\\d{7})|(\\d{3}([-]\\d{2}){2})|([-]\\d{4}))");
        Matcher matcher = p.matcher(telNumber);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
