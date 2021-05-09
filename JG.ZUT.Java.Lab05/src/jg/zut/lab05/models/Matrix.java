package jg.zut.lab05.models;

public class Matrix {


    protected double[][] rawMatrix = null;
    private int rows = 0, cols = 0;

    public Matrix(int rows, int cols)
    {
        rawMatrix = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(double[][] data)
    {
        if(data != null)
        {
            this.rawMatrix = data.clone();
            rows = this.rawMatrix.length;
            cols = this.rawMatrix[0].length;
        }
    }

    public double get(int row, int col)
    {
        return rawMatrix[row][col];
    }

    public void set(int row, int col, double value)
    {
        rawMatrix[row][col] = value;
    }

    public int getCols(){
        return this.cols;
    }

    public int getRows(){
        return this.rows;
    }

    public void initialize(){
        this.rawMatrix = new double[this.rows][this.cols];
    }

    public void setCols(int cols){
        this.cols = cols;
        if(this.rows != 0){
            initialize();
        }
    }

    public void setRows(int rows){
        this.rows = rows;
        if(this.cols != 0){
            initialize();
        }
    }

    public boolean isNotNull(){
        return rawMatrix != null == true;
    }

    public void transpose()
    {
        Matrix result = new Matrix(cols, rows);

        for (int row = 0; row < rows; ++row)
        {
            for (int col = 0; col < cols; ++col)
            {
                result.rawMatrix[col][row] = rawMatrix[row][col];
            }
        }

        this.rawMatrix = result.rawMatrix;
    }

    public Matrix multiply(Matrix second)
    {
        double[][] result = new double[this.rawMatrix.length][second.rawMatrix[0].length];
        for (int row = 0; row < result.length; row++)
        {
            for (int col = 0; col < result[row].length; col++)
            {
                result[row][col] = multiplySingleCell(rawMatrix, second.rawMatrix, row, col);
            }
        }
        return new Matrix(result);
    }

    private double multiplySingleCell(double[][] first, double[][] second, int row, int col)
    {
        double cellValue = 0;
        for (int i = 0; i < second.length; i++)
        {
            cellValue += first[row][i] * second[i][col];
        }
        return cellValue;
    }

}
