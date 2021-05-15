package jg.zut.java.lab09.model;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.converters.HandlowiecToStringConverter;

import java.io.Serializable;
import java.math.BigDecimal;

public class Handlowiec extends Pracownik implements Serializable {

    private transient IEmployeeToStringConverter converter;

    public Handlowiec(){
        converter = new HandlowiecToStringConverter();
    }

    public Handlowiec(BigDecimal prowizja, BigDecimal limitProwizjiMiesieczny){
        this();
        this.prowizja = prowizja;
        this.limitProwizjiMiesieczny = limitProwizjiMiesieczny;
    }


    private BigDecimal prowizja;

    public BigDecimal getProwizja() {
        return prowizja;
    }

    public void setProwizja(BigDecimal prowizja) {
        this.prowizja = prowizja;
    }

    public BigDecimal getLimitProwizjiMiesieczny() {
        return limitProwizjiMiesieczny;
    }

    public void setLimitProwizjiMiesieczny(BigDecimal limitProwizjiMiesieczny) {
        this.limitProwizjiMiesieczny = limitProwizjiMiesieczny;
    }

    private BigDecimal limitProwizjiMiesieczny;

    @Override
    public String getEmployeeInfo() {
        return String.format(
                "Identyfikator PESEL             :            %s \n" +
                        "Imie                            :            %s \n" +
                        "Nazwisko                        :            %s \n" +
                        "Stanowisko                      :            %s \n" +
                        "Wynagrodzenie(zł)               :            %s \n" +
                        "Telefon służbowy numer          :            %s \n" +
                        "Prowizja (%%)                    :            %s \n" +
                        "Limit prowizji/miesiąc (zł)     :            %s \n",
                getPesel(), getImie(), getNazwisko(), getStanowisko(), getWynagrodzenie(),
                getNumerTelefonu(), getProwizja(), getLimitProwizjiMiesieczny());
    }
}
