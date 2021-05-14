package jg.zut.java.lab09.controller;

import jg.zut.java.lab09.base.IEmployeeController;
import jg.zut.java.lab09.base.Pracownik;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public boolean serialize() {
        return false;
    }

    @Override
    public boolean deserialize() {
        return false;
    }

    public Iterator<Pracownik> getIterator(){
        return dic.values().iterator();
    }
}
