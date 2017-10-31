package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
