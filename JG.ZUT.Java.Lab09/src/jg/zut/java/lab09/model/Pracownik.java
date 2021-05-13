package jg.zut.java.lab09.model;

import java.math.BigDecimal;

public abstract class Pracownik {

    private String pesel;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public BigDecimal getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(BigDecimal wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getKartaSluzbowaNumer() {
        return kartaSluzbowaNumer;
    }

    public void setKartaSluzbowaNumer(String kartaSluzbowaNumer) {
        this.kartaSluzbowaNumer = kartaSluzbowaNumer;
    }

    private String imie;
    private String nazwisko;
    private String stanowisko;
    private BigDecimal wynagrodzenie;
    private String numerTelefonu;
    private String kartaSluzbowaNumer;






}
