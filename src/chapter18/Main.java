package chapter18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("./src/chapter18/txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            String buf;
            while ((buf = read.readLine()) != null) {
                System.out.println(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
