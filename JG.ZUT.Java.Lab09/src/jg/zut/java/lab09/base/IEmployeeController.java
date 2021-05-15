package jg.zut.java.lab09.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public interface IEmployeeController<T extends Pracownik> {


    Map<String, T> get();
    int size();
    T get(String pesel);
    boolean add(T employee);
    boolean contains(T employee);
    boolean delete(String pesel);
    Iterator<Pracownik> getIterator();
    boolean serializeGzip(String filePathWithNoExt);
    boolean serializeZip(String filePathWithNoExt);
    void deserialize(String fullFileNameWithExt) throws IOException, ClassNotFoundException;
    Map<String, T> deserializeGzip(String fullFileName) throws IOException, ClassNotFoundException;
    Map<String, T> deserializeZip(String fullFileName) throws IOException, ClassNotFoundException;
}
