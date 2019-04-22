package chapter18.section6;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) {
        StringReader reader = new StringReader("");
        int r = 0;
        while (true) {
            try {
                r = reader.read();
                System.out.print((char) r);

                if (r == -1){
                    break;
                }
                System.out.print(' ');
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println();
    }
}
