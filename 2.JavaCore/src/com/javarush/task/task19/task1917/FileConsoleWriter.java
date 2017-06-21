package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public void write(int i) throws IOException {
        fileWriter.write(i);
        System.out.println(i);
    }

    public void write(String s) throws IOException {
        System.out.println(s);
        fileWriter.write(s);
    }

    public void write(String s, int off, int len) throws IOException {
        System.out.println(s.substring(off, off + len));
        fileWriter.write(s, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        System.out.println(cbuf);
        fileWriter.write(cbuf);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.println(String.valueOf(cbuf).substring(off, off + len));
        fileWriter.write(cbuf, off, len);
    }

    public void close() throws IOException{
        fileWriter.close();
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public static void main(String[] args) {

    }

}
