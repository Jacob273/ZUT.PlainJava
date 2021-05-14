package jg.zut.java.lab09.controller;
import jg.zut.java.lab09.model.Dyrektor;
import jg.zut.java.lab09.model.Handlowiec;

import java.math.BigDecimal;

public class DummyController extends EmployeeController{

    public DummyController(){
        super();

        Dyrektor p1 = new Dyrektor();
        p1.setPesel("92030313030");
        p1.setImie("Bogusz");
        p1.setNazwisko("Kowalski");
        p1.setStanowisko("Dyrektor operacyjny");
        p1.setWynagrodzenie(new BigDecimal(5500));
        p1.setNumerTelefonu("501200300");
        p1.setKartaSluzbowaNumer("777");
        p1.setDodatekSluzbowy(new BigDecimal(3500));
        p1.setLimitKosztowMiesieczny(new BigDecimal(111500));

        Handlowiec p2 = new Handlowiec();
        p2.setPesel("81030313030");
        p2.setImie("Euzebiusz");
        p2.setNazwisko("Nowak");
        p2.setStanowisko("Spec. ds. sprzedazy");
        p2.setWynagrodzenie(new BigDecimal(5500));
        p2.setNumerTelefonu("502200300");
        p2.setKartaSluzbowaNumer("776");
        p2.setProwizja(new BigDecimal(23));
        p2.setLimitProwizjiMiesieczny(new BigDecimal(14500));

        Handlowiec p3 = new Handlowiec();
        p3.setPesel("71030313030");
        p3.setImie("Andrzej");
        p3.setNazwisko("Popularny");
        p3.setStanowisko("Starszy spec. ds. sprzedazy");
        p3.setWynagrodzenie(new BigDecimal(7500));
        p3.setNumerTelefonu("503200300");
        p3.setKartaSluzbowaNumer("776");
        p3.setProwizja(new BigDecimal(25));
        p3.setLimitProwizjiMiesieczny(new BigDecimal(17500));

        Dyrektor p4 = new Dyrektor();
        p4.setPesel("72030313030");
        p4.setImie("Krzysztof");
        p4.setNazwisko("Jędrzejczyk");
        p4.setStanowisko("Dyrektor finansowy");
        p4.setWynagrodzenie(new BigDecimal(11500));
        p4.setNumerTelefonu("504200300");
        p4.setKartaSluzbowaNumer("775");
        p4.setDodatekSluzbowy(new BigDecimal(3500));
        p4.setLimitKosztowMiesieczny(new BigDecimal(111500));

        add(p1);
        add(p2);
        add(p3);
        add(p4);

    }
}
