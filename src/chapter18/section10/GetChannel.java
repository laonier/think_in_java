package chapter18.section10;

import common.Constant;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    public static void main(String[] args) throws IOException {
        String filename = Constant.PATH_CHAPTER18_SECTION10 + "file/file_channel.txt";
        FileChannel fc = new FileOutputStream(new File(filename).getAbsoluteFile()).getChannel();
        fc.write(ByteBuffer.wrap("something ".getBytes()));
        fc.close();
        fc = new RandomAccessFile(new File(filename).getAbsoluteFile(), "rw").getChannel();
        fc.write(ByteBuffer.wrap("something more".getBytes()));
        fc.close();
        fc = new FileInputStream(new File(filename).getAbsoluteFile()).getChannel();
        ByteBuffer bb = ByteBuffer.allocate(10);
        while ((fc.read(bb)) != -1) {
            bb.flip();
            while (bb.hasRemaining()) {
                System.out.println((char)bb.get());
            }
        }
    }
}
