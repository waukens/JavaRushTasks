package com.javarush.task.task31.task3110;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectories(zipFile.getParent());
        }
        try (
                ZipOutputStream zOs = new ZipOutputStream(Files.newOutputStream(zipFile))
        ) {
            if (Files.isDirectory(source)) {
                FileManager fM = new FileManager(source);
                List<Path> fileNames = fM.getFileList();
                for (Path fileName : fileNames) {
                    addNewZipEntry(zOs, source, fileName);
                }
            } else if (Files.isRegularFile(source)) {
                    addNewZipEntry(zOs, source.getParent(), source.getFileName());
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }


    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream iS = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry zE = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zE);
            copyData(iS, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }
    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            out.write(in.read());
        }
    }
}
