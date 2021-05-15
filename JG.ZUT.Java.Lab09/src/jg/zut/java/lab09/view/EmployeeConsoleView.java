package jg.zut.java.lab09.view;

import jg.zut.java.lab09.base.IEmployeeController;
import jg.zut.java.lab09.base.IEmployeeView;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.controller.DummyController;
import jg.zut.java.lab09.model.Dyrektor;
import jg.zut.java.lab09.model.Handlowiec;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeConsoleView implements IEmployeeView {

    private final Scanner inputScanner;
    private final IEmployeeController<Pracownik> controller;

    public EmployeeConsoleView(){
        inputScanner = new Scanner(System.in);
        controller = new DummyController();
    }

      String inputPesel;
      String inputImie;
      String inputNazwisko;
      String inputStanowisko;
      BigDecimal inputWynagrodzenie;
      String inputNumerTeleFonu;
      String inputKartaSluzbowa;

    public void show(){

        while(true)
        {
            menu();
            int choice = getNumber();

            switch(choice){
                case 1: {
                    Iterator<Pracownik> iterator = getIterator();
                    int counter = 1;
                    Pracownik p = iterator.next();
                    boolean pickNext = true;
                    while (p != null && pickNext) {
                        printStars();
                        System.out.println(p.getEmployeeInfo());
                        printStars();
                        System.out.println(String.format("%s of %s", counter++, controller.size()));
                        showEnterOrQ();
                        printStars();
                        String input = getString();
                        switch (input.toLowerCase(Locale.ROOT)) {
                            case "":
                                pickNext = true;
                                p = null;
                                if(iterator.hasNext())
                                {
                                    p = iterator.next();
                                }
                                break;
                            case "q":
                                pickNext = false;
                                break;
                        }
                    }
                }
                continue;
                case 2: {
                    showDyrektorHandlowiec();
                    printStars();
                    String inputChoice = getString();

                    System.out.println("PESEL: ");
                    inputPesel = getString();
                    System.out.println("IMIE: ");
                    inputImie = getString();
                    System.out.println("NAZWISKO: ");
                    inputNazwisko = getString();
                    System.out.println("STANOWISKO: ");
                    inputStanowisko = getString();
                    System.out.println("WYNAGRODZENIE: ");
                    inputWynagrodzenie = getBigNumber();
                    System.out.println("NUMER TELEFONU: ");
                    inputNumerTeleFonu = getString();
                    System.out.println("KARTA SLUZBOWA NUMER: ");
                    inputKartaSluzbowa = getString();

                    Pracownik newEmployee;
                    switch (inputChoice.toLowerCase(Locale.ROOT)) {
                        case "d":
                            System.out.println("Dodatek sluzbowy:");
                            BigDecimal dodatekSluzbowy = getBigNumber();
                            System.out.println("Limit prowizji:");
                            BigDecimal limitKosztow = getBigNumber();
                            newEmployee = new Dyrektor(dodatekSluzbowy, limitKosztow);
                            break;
                        case "h":
                            System.out.println("Prowizja: ");
                            BigDecimal prowizja = getBigNumber();
                            System.out.println("Limit prowizji: ");
                            BigDecimal limitProwizji = getBigNumber();
                            newEmployee = new Handlowiec(prowizja, limitProwizji);
                            break;
                        default:
                            newEmployee = new Handlowiec();
                    }

                    newEmployee.setPesel(inputPesel);
                    newEmployee.setImie(inputImie);
                    newEmployee.setNazwisko(inputNazwisko);
                    newEmployee.setStanowisko(inputStanowisko);
                    newEmployee.setWynagrodzenie(inputWynagrodzenie);
                    newEmployee.setNumerTelefonu(inputNumerTeleFonu);
                    newEmployee.setKartaSluzbowaNumer(inputKartaSluzbowa);
                    controller.add(newEmployee);
                    continue;
                }
                case 3: {
                    System.out.println("Podaj identyfikator PESEL:");
                    String inputPesel = getString();
                    Pracownik p = controller.get(inputPesel);
                    if (p == null) {
                        System.out.println("Nieprawidłowy identyfikator pesel.");
                        continue;
                    }
                    System.out.println(p.getEmployeeInfo());
                    System.out.println("[Enter] - Potwierdź");
                    System.out.println("[Q] - porzuć");
                    String inputChoice = getString();
                    switch (inputChoice.toLowerCase(Locale.ROOT)) {
                        case "":
                            controller.delete(inputPesel);
                            continue;
                        case "q":
                            break;
                    }
                }
                case 4: {
                    System.out.println("[Z]achowaj/[O]twórz");
                    String inputChoice = getString();
                    switch (inputChoice.toLowerCase(Locale.ROOT)) {
                        case "z":
                            System.out.println("Kompresja [G]zip/[Z]ip");
                            inputChoice = getString();
                            switch (inputChoice.toLowerCase(Locale.ROOT)) {
                                case "g":
                                    System.out.println("KOMPRESJA G TUDUDUD zakończona");
                                    break;
                                case "z":
                                    System.out.println("KOMPRESJA Z TUDUDUD zakończona");
                                    break;
                            }
                            continue;
                        case "o":
                            System.out.println("Nazwa pliku:");
                            inputChoice = getString();
                            System.out.println("[Enter] - potwierdź");
                            System.out.println("[Q] - porzuć");
                             inputChoice = getString();
                            switch (inputChoice.toLowerCase(Locale.ROOT)) {
                                case "":
                                    System.out.println("Otwieram: " + inputChoice);
                                    break;
                                case "q":
                                    break;
                            }
                            break;
                    }
                }
                continue;
                case 5:
                    System.out.println("Kończenie progogramu...");
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
        System.out.println("    5.  Koniec");
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
    public BigDecimal getBigNumber() {
        BigDecimal d = inputScanner.nextBigDecimal();
        inputScanner.nextLine();
        return d;
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

    @Override
    public void showDyrektorHandlowiec() {
        System.out.println("[D]yrektor/[H]andlowiec");
    }

}
