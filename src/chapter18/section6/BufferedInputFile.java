package chapter18.section6;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedInputFile {
    public static String read(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String buf;
        while ((buf = reader.readLine()) != null) {
            sb.append(buf).append("\n");
        }
        return sb.toString();
    }
}
