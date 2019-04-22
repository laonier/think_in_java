package chapter18.section7;

import java.io.*;
import java.util.ArrayList;

public class TextFile extends ArrayList<String> {
    public String read(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new FileReader(filename));
                String buf;
                while ((buf = reader.readLine()) != null) {
                    sb.append(buf).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public void write(String filename) {
        try {
            PrintWriter p = new PrintWriter(filename);
            for (String buf: this) {
                p.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
