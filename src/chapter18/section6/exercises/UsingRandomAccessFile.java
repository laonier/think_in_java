package chapter18.section6.exercises;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    public static void main(String[] args) throws Exception {
        String file = "./src/chapter18/section6/warehouse.txt";
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.writeBoolean(false);
        raf.writeDouble(1.23456789);
        raf.writeInt(99);
        raf.writeUTF("this is a UTF string.");
        raf.close();
        raf = new RandomAccessFile(file, "r");
        raf.seek(1 + 8);
        System.out.println(raf.readInt());
    }
}
