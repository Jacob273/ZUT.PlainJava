package jg.zut.java.lab09;

import jg.zut.java.lab09.view.EmployeeConsoleView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EmployeeConsoleView view = new EmployeeConsoleView();
        view.show();
    }
}
