package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String firstFile = args[0];
        String secondFile = args[1];
        Charset cp1251 = Charset.forName("cp1251");
        Charset utf8 = Charset.forName("UTF-8");
        try (
                InputStreamReader sReader = new InputStreamReader(new FileInputStream(firstFile), utf8);
                OutputStreamWriter sWriter = new OutputStreamWriter(
                        new FileOutputStream(secondFile), cp1251)
                ) {
            while (sReader.ready()) {
                sWriter.write(sReader.read());
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
