package jg.zut.java.lab09.model;

import java.math.BigDecimal;

public class Handlowiec extends Pracownik {

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
}
