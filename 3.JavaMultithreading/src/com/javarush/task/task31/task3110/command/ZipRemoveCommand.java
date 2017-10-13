package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите путь к файлу архива из которого необходимо удалить файлы:");
        Path deletingPath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(deletingPath);

        ConsoleHelper.writeMessage("Файлы удалены.");
    }
}
