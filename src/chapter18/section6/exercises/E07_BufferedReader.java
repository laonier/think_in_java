package chapter18.section6.exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class E07_BufferedReader {

    public static void main(String[] args) throws Exception {
        String file = "./src/chapter18/section6/exercises/test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String buf;
        List<String> txt = new LinkedList<>();
        while ((buf = reader.readLine()) != null) {
            txt.add(buf);
        }
        reader.close();
        ListIterator<String> ite = txt.listIterator(txt.size());
        while (ite.hasPrevious()) {
            System.out.println(ite.previous().toUpperCase());
        }
    }
}
