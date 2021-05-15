package jg.zut.java.lab09.controller;

import jg.zut.java.lab09.base.IEmployeeController;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.serialization.Serializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EmployeeController implements IEmployeeController {


    protected LinkedHashMap<String, Pracownik> dic;

    public EmployeeController(){
        dic = new LinkedHashMap<String, Pracownik>();
    }

    @Override
    public Map<String, Pracownik> get() {
        return dic;
    }

    @Override
    public int size() {
        return dic.size();
    }

    @Override
    public Pracownik get(String pesel) {
        if(!dic.containsKey(pesel)){
            return null;
        }
        return dic.get(pesel);
    }

    @Override
    public boolean add(Pracownik employee) {
        String pesel = employee.getPesel();
        if(!dic.containsKey(pesel)){
            dic.put(pesel, employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Pracownik employee) {
        return dic.containsKey(employee.getPesel());
    }

    @Override
    public boolean delete(String pesel) {
        return dic.remove(pesel) != null;
    }

    @Override
    public boolean serializeGzip(String filePathWithNoExt) {
        try{
            Serializer s = new Serializer();
            s.saveDataGzip(filePathWithNoExt, this.dic);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean serializeZip(String filePathWithNoExt) {
        try{
            Serializer s = new Serializer();
            s.saveDataZip(filePathWithNoExt, this.dic);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public void deserialize(String fullFileNameWithExt) throws IOException, ClassNotFoundException {
        int index = fullFileNameWithExt.lastIndexOf('.');
        String extension = fullFileNameWithExt.substring(index + 1);
        if (extension.equals("gz"))
        {
            deserializeGzip(fullFileNameWithExt);
        }
        else{
            deserializeZip(fullFileNameWithExt);
        }
    }

    @Override
    public LinkedHashMap<String, Pracownik> deserializeGzip(String fullFileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fullFileName);
        InflaterInputStream gzipStream = new GZIPInputStream(file);
        ObjectInputStream objectInputstream = new ObjectInputStream(gzipStream);
        this.dic = (LinkedHashMap<String, Pracownik>)objectInputstream.readObject();
        objectInputstream.close();
        return this.dic;
    }

    @Override
    public Map deserializeZip(String fullFileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fullFileName);
        ZipInputStream zipInputStream = new ZipInputStream(file);
        ZipEntry entry = zipInputStream.getNextEntry();
        ObjectInputStream objectInputstream = new ObjectInputStream(zipInputStream);
        this.dic = (LinkedHashMap<String, Pracownik>)objectInputstream.readObject();
        objectInputstream.close();
        return this.dic;
    }

    public Iterator<Pracownik> getIterator(){
        return dic.values().iterator();
    }
}
