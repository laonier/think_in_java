package chapter18.section6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception {
        byte[] buff = BufferedInputFile.read("./src/chapter18/section6/file/linefeed.txt").getBytes();
        DataInputStream dis = new DataInputStream(
                new ByteArrayInputStream(buff));
        try {
            while (dis.available() != 0) {
                System.out.println((char)dis.readByte());
            }
        } catch (EOFException e) {
        }
    }
}
