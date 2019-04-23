package chapter18.section6.exercises;

import common.Constant;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class E14_BaseFileOutput {
    public static void main(String[] args) throws Exception {
        String destination = Constant.PATH_CHAPTER18_SECTION06 + "/exercises/line_number.out";
        String source = Constant.PATH_CHAPTER18_SECTION06 + "/file/linefeed.txt";
        LineNumberReader reader = new LineNumberReader(new FileReader(source));
        PrintWriter writer = new PrintWriter(destination);
        String buf;
        while ((buf = reader.readLine()) != null) {
            writer.println(reader.getLineNumber() + ": " + buf);
        }
        writer.close();
    }
}
