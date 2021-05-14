package jg.zut.java.lab09.base;

import java.math.BigDecimal;
import java.util.Iterator;

public interface IEmployeeView {

    void show();
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
