package jg.zut.lab05.views;

import jg.zut.lab05.controllers.MatrixController;
import jg.zut.lab05.models.Matrix;

import java.util.Scanner;

import static jg.zut.lab05.controllers.MatrixController.*;

public class ConsoleView  {

    Scanner inputScanner;
    MatrixController controller;

    public ConsoleView()
    {
        inputScanner =  new Scanner(System.in);
        controller = new MatrixController();
    }

    public void show()
    {
        while(true)
        {
            DisplayOptions(1);

            int result = inputScanner.nextInt();

            switch(result)
            {
                case 1:
                    displayNewLine("Wprowadz liczbe kolumn dla A: ");
                    controller.putCols(M1, inputScanner.nextInt());
                    displayNewLine("Wprowadz liczbe wierszy dla A: ");
                    controller.putRows(M1, inputScanner.nextInt());
                    displayNewLine("Wprowadz dane dla A: ");
                    getMatrix(M1);
                    displayNewLine("Wprowadz liczbe kolumn dla B: ");
                    controller.putCols(M2, inputScanner.nextInt());
                    displayNewLine("Wprowadz liczbe wierszy dla B: ");
                    controller.putRows(M2, inputScanner.nextInt());
                    displayNewLine("Wprowadz dane dla B: ");
                    getMatrix(M2);
                    break;

                case 2:
                    DisplayOptions(2);
                    result = inputScanner.nextInt();
                    switch(result)
                    {
                        case 1:
                            displayNewLine("...Wykonywana jest transpozycja macierzy wejsciowych...");
                            controller.transpose(M1);
                            controller.transpose(M2);
                            break;
                        case 2:
                            displayNewLine("...Wykonywane jest mnozenie...");
                            controller.mutliply(M1,M2);
                            break;
                        case 3:
                            displayNewLine("...Wykonywana jest transpozycja macierzy wynikowej...");
                            controller.transpose(MResult);
                            break;
                    }
                    break;
                case 3:
                    DisplayOptions(3);
                    result = inputScanner.nextInt();
                    switch(result)
                    {
                        case 1:
                            displayNewLine("...Wyswietlanie macierzy wejsciowych...");
                            displayMatrix(M1);
                            displayNewLine("");
                            displayMatrix(M2);
                            break;
                        case 2:
                            displayNewLine("...Wyswietlanie macierzy wynikowej...");
                            displayMatrix(MResult);
                            break;
                    }
                    break;
            }
        }
    }

    public void DisplayOptions(int menuOption){
        switch(menuOption)
        {
            case 1:
                System.out.println("(1) Wprowadz macierze wejsciowe");
                System.out.println("(2) Operacje arytmetyczne");
                System.out.println("(3) Wyswietl macierze");
                break;
            case 2:
                System.out.println("(2.1) Transponuj macierze wejsciowe");
                System.out.println("(2.2) Pomnoz macierze wejsciowe");
                System.out.println("(2.3) Transponuj macierz wynikowa");
                break;
            case 3:
                System.out.println("(3.1) Wyswietl macierze wejsciowe");
                System.out.println("(3.2) Wyswietl macierz wynikowa");
                break;
        }
    }

    public void getMatrix(String matrixName)
    {
        int rows = this.controller.get(matrixName).getRows();
        int cols = this.controller.get(matrixName).getCols();

        for (int row = 0; row < rows; ++row)
        {
            for (int col = 0; col < cols; ++col)
            {
                System.out.print("[" + row + " " + col + "]");
                controller.set(matrixName, row,col, inputScanner.nextDouble());
            }
        }
    }

    public void displayMatrix(String matrixName)
    {
        System.out.print("[");
        Matrix m = controller.get(matrixName);
        for (int row = 0; row < m.getRows(); ++row)
        {
            if (row != 0)
            {
                System.out.print(" ");
            }

            System.out.print("[");

            for (int col = 0; col < m.getCols(); ++col)
            {
                System.out.printf("%8.3f", m.get(row,col));
                if (col != m.getCols() - 1)
                {
                    System.out.print(" ");
                }
            }

            System.out.print("]");
            if (row == m.getRows() - 1)
            {
                System.out.print("]");
            }

            System.out.println();
        }
    }

    public void close(){
        inputScanner.close();
    }

    public void displayNewLine(String message)
    {
        System.out.println(message);
    }
}
