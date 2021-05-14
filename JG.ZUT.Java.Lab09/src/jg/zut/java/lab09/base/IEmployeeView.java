package jg.zut.java.lab09.base;

import java.util.Iterator;

public interface IEmployeeView {

    void show();
    void menu();
    Iterator<Pracownik> getIterator();
    int getNumber();
    String getString();
    void printStars();
    void goodBye();
    void showEnterOrQ();

}
