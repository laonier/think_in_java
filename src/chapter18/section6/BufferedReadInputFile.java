package chapter18.section6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReadInputFile {
    public static void main(String[] args) throws Exception {
        String file = "./src/chapter18/section6/test.txt";
        FileReader reader = new FileReader(file);

        BufferedReader bf = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        int buffer;
        while ((buffer = bf.read()) != -1 ) {
            sb.append((char) buffer).append("\n");
        }
        System.out.println(sb);
    }
}
