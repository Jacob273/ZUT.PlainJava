package jg.zut.lab05.controllers;

import jg.zut.lab05.models.Matrix;
import java.util.HashMap;
import java.util.Map;

public class MatrixController {

    public static final String M1 = "M1";
    public static final String M2 = "M2";
    public static final String MResult = "MResult";

    Map<String, Matrix> dict;

    public MatrixController()
    {
        dict = new HashMap<String, Matrix>(){{
            put(M1, new Matrix(null));
            put(M2, new Matrix(null));
            put(MResult, new Matrix(null));
        }};
    }

    public void putCols(String key, int cols){
        Matrix m = dict.get(key);
        m.setCols(cols);
    }

    public void putRows(String key, int rows){
        Matrix m = dict.get(key);
        m.setRows(rows);
    }

    public int getCols(String key){
        return dict.get(key).getCols();
    }

    public int getRows(String key){
        return dict.get(key).getRows();
    }

    public double get(String key, int row, int col){
        Matrix m = dict.get(key);
        return m.get(row, col);
    }

    public void transpose(String key){
        Matrix m = dict.get(key);
        m.transpose();
    }

    public Matrix get(String key){
        return dict.get(key);
    }

    public void set(String key, int cols, int rows, double value){
        Matrix m = dict.get(key);
        m.set(cols, rows, value);
    }

    public void mutliply(String firstName, String secondName)
    {
        Matrix first = dict.get(firstName);
        Matrix second = dict.get(secondName);
        dict.put(MResult, first.multiply(second));
    }


}
