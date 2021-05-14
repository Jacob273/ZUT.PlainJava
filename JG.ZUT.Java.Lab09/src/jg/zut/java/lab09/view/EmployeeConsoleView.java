package jg.zut.java.lab09.view;

import jg.zut.java.lab09.base.IEmployeeController;
import jg.zut.java.lab09.base.IEmployeeView;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.controller.DummyController;

import java.util.Iterator;
import java.util.Scanner;

public class EmployeeConsoleView implements IEmployeeView {

    private final Scanner inputScanner;
    private final IEmployeeController<Pracownik> controller;

    public EmployeeConsoleView(){
        inputScanner = new Scanner(System.in);
        controller = new DummyController();
    }


    public void show(){

        while(true)
        {
            menu();
            int choice = getNumber();

            switch(choice){
                case 1: {
                    Iterator<Pracownik> iterator = getIterator();
                    Pracownik p = iterator.next();
                    boolean pickNext = true;
                    while (p != null && pickNext) {
                        printStars();
                        System.out.println(p.getEmployeeInfo());
                        printStars();
                        System.out.println(String.format("X of %s", controller.size()));
                        showEnterOrQ();
                        printStars();
                        String input = getString();
                        switch (input) {
                            case "":
                                pickNext = true;
                                p = iterator.next();
                                break;
                            case "Q":
                            case "q":
                                pickNext = false;
                                break;
                        }
                    }
                }
                break;
            }
            break;
        }

        goodBye();

    }

    @Override
    public void menu() {
        System.out.println("MENU");
        System.out.println("    1.  Lista pracowników");
        System.out.println("    2.  Dodaj pracownika");
        System.out.println("    3.  Usuń pracownika");
        System.out.println("    4.  Kopia zapasowa");
    }

    @Override
    public Iterator<Pracownik> getIterator() {
        return controller.getIterator();
    }

    @Override
    public int getNumber() {
        int number = inputScanner.nextInt();
        inputScanner.nextLine();
        return number;
    }

    @Override
    public String getString() {
        return inputScanner.nextLine();
    }

    @Override
    public void printStars() {
        for(int i = 0 ; i < 40; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    @Override
    public void goodBye() {
        printStars();
        System.out.println(">>Goodbye<<");
        printStars();
    }

    @Override
    public void showEnterOrQ() {
        System.out.println("[Enter] - następny");
        System.out.println("[Q] - powrót");
    }

}
