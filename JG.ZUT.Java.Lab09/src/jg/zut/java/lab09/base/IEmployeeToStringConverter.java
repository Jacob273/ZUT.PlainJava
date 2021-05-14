package jg.zut.java.lab09.base;

public interface IEmployeeToStringConverter<TConvertType extends Pracownik> {

    String convert(TConvertType t);
}
