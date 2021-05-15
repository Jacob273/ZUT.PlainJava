package jg.zut.java.lab09.converters;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.model.Dyrektor;

public class DyrektorToStringConverter implements IEmployeeToStringConverter<Dyrektor> {





    @Override
    public String convert(Dyrektor p) {
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
                p.getPesel(), p.getImie(), p.getNazwisko(), p.getStanowisko(), p.getWynagrodzenie(),
                p.getNumerTelefonu(), p.getDodatekSluzbowy(), p.getKartaSluzbowaNumer(), p.getLimitKosztowMiesieczny());
    }
}
