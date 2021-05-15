package jg.zut.java.lab09.base;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

public interface IEmployeeView {

    void show() throws IOException, ClassNotFoundException;
    void menu();
    Iterator<Pracownik> getIterator();
    int getNumber();
    String getString();
    BigDecimal getBigNumber();
    void printStars();
    void goodBye();
    void showEnterOrQ();
    void showDyrektorHandlowiec();

}
