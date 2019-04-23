package chapter18.section8;

import common.Constant;

import java.io.*;

public class RedirectSystemStream {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        String inFile = Constant.PATH_CHAPTER18_SECTION08 + "file/redirect.txt";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
        String outFile = Constant.PATH_CHAPTER18_SECTION08 + "file/out.txt";
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        String buf;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while ((buf = bf.readLine()) != null) {
            System.out.println(buf + "&" + buf);
        }
        out.close();
        System.setOut(console);
    }
}
