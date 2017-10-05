package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Archiver {
    public static Operation askOperation() throws IOException {
        Map<Integer, String> listOfOperations = new HashMap<>();
        listOfOperations.put(0, "упаковать файлы в архив");
        listOfOperations.put(1, "добавить файл в архив");
        listOfOperations.put(2, "удалить файл из архива");
        listOfOperations.put(3, "распаковать архив");
        listOfOperations.put(4, "просмотреть содержимое архива");
        listOfOperations.put(5, "выход");
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (int key : listOfOperations.keySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %s", key, listOfOperations.get(key)));
        }
        int numOfOperation = ConsoleHelper.readInt();
        Operation operation = null;
        for (Operation oper : Operation.values()) {
            if (oper.ordinal() == numOfOperation) {
                operation = oper;
            }
        }
        return operation;
    }

    public static void main(String[] args) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Operation operation = null;
//        System.out.print("Enter file/folder's path to zip:");
//        try {
//            ZipFileManager zFm = new ZipFileManager(Paths.get(reader.readLine()));
//            System.out.print("Enter path to archiver: ");
//            zFm.createZip(Paths.get(reader.readLine()));
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }
}
