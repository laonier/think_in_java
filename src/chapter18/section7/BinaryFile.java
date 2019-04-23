package chapter18.section7;

import common.Constant;

import java.io.*;

public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        try (BufferedInputStream out = new BufferedInputStream(
                new FileInputStream(file))) {
            byte[] result = new byte[out.available()];
            out.read(result);
            return result;
        }
    }
    public static byte[] read(String filename) throws IOException {
        return read(new File(filename).getAbsoluteFile());
    }
    public static void main(String[] args) {
        try {
            byte[] fileBytes = read(Constant.PATH_CHAPTER18_SECTION07 + "BinaryFile.java");
            for (byte b: fileBytes) {
                System.out.println((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
