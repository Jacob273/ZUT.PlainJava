package jg.zut.first.lab01;

import jg.zut.first.helpers.Printer;

public class Main {

    public static void main(String[] args) {
        Printer.print("Hello123");
        String version = System.getProperty("java.version");
        Printer.print(String.format("Java VErsion <%s>", version));


        Object o = new Object();
        float dub = 5.0f;
        o = (double)dub;
        int i = (int)o;
        Printer.print(i);
    }
}
