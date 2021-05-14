package jg.zut.java.lab09.model;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.base.Pracownik;
import jg.zut.java.lab09.converters.DyrektorToStringConverter;
import java.math.BigDecimal;

public class Dyrektor extends Pracownik {

    IEmployeeToStringConverter converter;

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
        return converter.convert(this);
    }
}
