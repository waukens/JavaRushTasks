package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file/folder's path to zip:");
        try {
            ZipFileManager zFm = new ZipFileManager(Paths.get(reader.readLine()));
            System.out.print("Enter path to archiver: ");
            zFm.createZip(Paths.get(reader.readLine()));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Command exitCommand = new ExitCommand();
        try {
            exitCommand.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
