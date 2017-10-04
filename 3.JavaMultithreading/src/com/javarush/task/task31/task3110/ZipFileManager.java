package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (
                ZipOutputStream zOs = new ZipOutputStream(Files.newOutputStream(zipFile));
                InputStream iS = Files.newInputStream(source)
        ) {
            ZipEntry zE = new ZipEntry(source.getFileName().toString());
            zOs.putNextEntry(zE);
            while (iS.available() > 0) {
                zOs.write(iS.read());
            }
            zOs.closeEntry();
        }




    }
}
