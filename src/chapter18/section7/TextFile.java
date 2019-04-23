package chapter18.section7;

import common.Constant;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
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
    public static void write(String filename, String txt) {
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(filename).getAbsoluteFile());
            p.print(txt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.close();
            }
        }
    }
    public void write(String filename) {
        PrintWriter p = null;
        try {
            p = new PrintWriter(filename);
            for (String buf: this) {
                p.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.close();
            }
        }
    }
    public TextFile(String filename, String splitter) {
        super(Arrays.asList(read(filename).split(splitter)));
        // regular expression split() often leaves an empty String at the first position.
        if (get(0).equalsIgnoreCase(" ")) remove(0);
    }
    public TextFile(String filename)  {
        this(filename, "\n");
    }

    public static void main(String[] args) {
        String filename = Constant.PATH_CHAPTER18_SECTION07 + "file/read.txt";
        String outFilename = Constant.PATH_CHAPTER18_SECTION07 + "file/out.txt";
        String fileContent = read(filename);
        write(filename, fileContent + "\nwrite");
        TextFile tf = new TextFile(filename);
        tf.write(outFilename);
    }
}
