package jg.zut.java.lab09.model;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.converters.DyrektorToStringConverter;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dyrektor extends Pracownik implements Serializable{
    private transient IEmployeeToStringConverter converter;

    public Dyrektor(){
        converter = new DyrektorToStringConverter();
    }

    public Dyrektor(BigDecimal dodatekSluzbowy, BigDecimal limitKosztowMiesieczny){
        this();
        this.dodatekSluzbowy = dodatekSluzbowy;
        this.limitKosztowMiesieczny = limitKosztowMiesieczny;
    }
    public BigDecimal getDodatekSluzbowy() {
        return dodatekSluzbowy;
    }

    public void setDodatekSluzbowy(BigDecimal dodatekSluzbowy) {
        this.dodatekSluzbowy = dodatekSluzbowy;
    }

    public BigDecimal getLimitKosztowMiesieczny() {
        return limitKosztowMiesieczny;
    }

    public void setLimitKosztowMiesieczny(BigDecimal limitKosztowMiesieczny) {
        this.limitKosztowMiesieczny = limitKosztowMiesieczny;
    }

    private BigDecimal dodatekSluzbowy;
    private BigDecimal limitKosztowMiesieczny;

    @Override
    public String getEmployeeInfo() {
        return String.format(
                "Identyfikator PESEL             :            %s \n" +
                        "Imie                            :            %s \n" +
                        "Nazwisko                        :            %s \n" +
                        "Stanowisko                      :            %s \n" +
                        "Wynagrodzenie(zł)               :            %s \n" +
                        "Telefon służbowy numer          :            %s \n" +
                        "Dodatek służbowy(zł)            :            %s \n" +
                        "Karta służbowera numer          :            %s \n" +
                        "Limit kosztów/miesiąc(zł)       :            %s",
                this.getPesel(), this.getImie(), this.getNazwisko(), this.getStanowisko(), this.getWynagrodzenie(),
                this.getNumerTelefonu(), this.getDodatekSluzbowy(), this.getKartaSluzbowaNumer(), this.getLimitKosztowMiesieczny());
    }
}
