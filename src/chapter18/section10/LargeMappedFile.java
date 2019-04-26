package chapter18.section10;

import common.Constant;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFile {
    static int length = 10;
    public static void main(String[] args) throws Exception {
        String filename = "F:/file_channel.txt";
        long time1 = System.currentTimeMillis();
        for (int m = 0; m < 1000; m++){
            FileChannel fc = new RandomAccessFile(new File(filename).getAbsoluteFile(), "rw").getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++) {
                mbb.get();
            }
        }
        long time2 = System.currentTimeMillis();
        for (int m = 0; m < 1000; m++){
            BufferedReader fc = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
            for (int i = 0; i < length; i++) {
                fc.read();
            }
        }
        long time3 = System.currentTimeMillis();
        System.out.println(String.valueOf(time2 - time1) + " : " + String.valueOf(time3 - time2));

    }
}
