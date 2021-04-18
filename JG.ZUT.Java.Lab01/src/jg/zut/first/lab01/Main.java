package jg.zut.first.lab01;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Date;


/**
 * Main class of the application.
 * @author jakubg
 * @since 2021
 * @version 1.0
 */
public class Main {


    /**
     * Color describing tree possible colors.
     */
    enum Color { RED, GREEN, BLUE; }

    static final String encoded = "V3lkemlhxYIgSW5mb3JtYXR5a2kgWmFjaG9kbmlvcG9tb3Jza2kgVW5pd2Vyc3l0ZXQgVGVjaG5vbG9naWN6bnkgdyBTemN6ZWNpbmll";

    /**
     * @param args arguments which are passed to the application entry point.
     */
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);

        for (int index = 0; index < decoded.length(); index += 10) {
            @SuppressWarnings("unused")
            char character = decoded.charAt(index);
            buffer.append(character);
        }
        System.out.print(decoded.replaceAll(MessageFormat.format("[{0}]", buffer.toString()), "-"));
        System.out.println();System.out.println();

        System.out.println(MessageFormat.format("{0, date, yyyy-MM-dd hh:mm:ss.SSS}", new Date()));
        System.out.println();System.out.println();

        //https://stackoverflow.com/questions/1104975/a-for-loop-to-iterate-over-an-enum-in-java
        //This values() method is implicitly declared by the compiler. So it is not listed on Enum doc.
        for( Color value : Color.values())
        {
            System.out.println(value.toString());
        }
    }
}
