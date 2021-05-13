package jg.zut.java.lab09.model;

import java.math.BigDecimal;

public class Dyrektor extends Pracownik {

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
}
