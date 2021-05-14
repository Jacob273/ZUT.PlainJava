package jg.zut.java.lab09.model;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.converters.HandlowiecToStringConverter;
import java.math.BigDecimal;

public class Handlowiec extends Pracownik {

    IEmployeeToStringConverter converter;

    public Handlowiec(){
        converter = new HandlowiecToStringConverter();
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
        return converter.convert(this);
    }
}
