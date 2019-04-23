package chapter18.section8;

import java.io.*;

public class Echo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String buf = null;
        try {
            while ((buf = reader.readLine()) != null) {
                System.out.println(buf.toUpperCase());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
