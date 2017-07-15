package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("city", "Moscow");
        map.put("tel", null);
        map.put("work", "dev");
        map.put(null, "m");
        map.put("lastname", "M");
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        if (!params.isEmpty() || params != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    sb.append(String.format("%s = \'%s\' and ", entry.getKey(), entry.getValue()));
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 5, sb.length());
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}
