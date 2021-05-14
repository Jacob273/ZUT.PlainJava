package jg.zut.java.lab09.converters;

import jg.zut.java.lab09.base.IEmployeeToStringConverter;
import jg.zut.java.lab09.model.Handlowiec;

public class HandlowiecToStringConverter implements IEmployeeToStringConverter<Handlowiec> {

        @Override
        public String convert(Handlowiec p) {
            return String.format(
                            "Identyfikator PESEL             :            %s \n" +
                            "Imie                            :            %s \n" +
                            "Nazwisko                        :            %s \n" +
                            "Stanowisko                      :            %s \n" +
                            "Wynagrodzenie(zł)               :            %s \n" +
                            "Telefon służbowy numer          :            %s \n" +
                            "Prowizja (%%)                    :           %s \n" +
                            "Limit prowizji/miesiąc (zł)     :            %s \n",
                    p.getPesel(), p.getImie(), p.getNazwisko(), p.getStanowisko(), p.getWynagrodzenie(),
                    p.getNumerTelefonu(), p.getProwizja(), p.getLimitProwizjiMiesieczny());
        }
}
