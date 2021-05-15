package jg.zut.java.lab09.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Serializer<T extends Serializable> {

    public void saveDataGzip(String filePath, T serializable) {
        try {

            FileOutputStream file = new FileOutputStream(filePath + ".gz");
            DeflaterOutputStream archiveStream = new GZIPOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(archiveStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataZip(String filePath, T serializable) {
        try {
            FileOutputStream file = new FileOutputStream(filePath + ".zip");

            ZipOutputStream zipOutputStream = new ZipOutputStream(file);
            ZipEntry zipEntry = new ZipEntry(filePath + ".zip");
            zipOutputStream.putNextEntry(zipEntry);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
