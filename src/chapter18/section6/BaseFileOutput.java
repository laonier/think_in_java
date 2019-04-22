package chapter18.section6;

import java.io.*;

public class BaseFileOutput {
    public static void main(String[] args) {
        String result = "./src/chapter18/section6/result.out";
        try {
            String file = "./src/chapter18/section6/linefeed.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(result)));
            String buf;
            int line = 0;
            while ((buf = reader.readLine()) != null) {
                writer.println(++line + ":" + buf);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
