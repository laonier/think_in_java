package chapter18.section8;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out, true);
        writer.println("hello");
        writer.println("word");
        writer.println(";");
        writer.printf("and hello myself!");
    }
}
