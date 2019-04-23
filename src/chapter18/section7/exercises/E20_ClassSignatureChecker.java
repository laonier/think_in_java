package chapter18.section7.exercises;

import chapter18.section1.Directory;
import chapter18.section7.BinaryFile;

import java.io.File;
import java.io.IOException;

public class E20_ClassSignatureChecker {
    static byte[] signature = {(byte)202, (byte)254, (byte)186, (byte)190};
    public static void main(String[] args) {
        file:
        for (File file: Directory.walk("./out", ".*\\.class")) {
            try {
                byte[] fileBytes = BinaryFile.read(file);
                for (int i = 0; i < signature.length; i++) {
                    if (signature[i] != fileBytes[i]) {
                        System.out.println(file.getName() + " is corrupt!");
                        break ;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
