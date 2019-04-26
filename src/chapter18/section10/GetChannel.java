package chapter18.section10;

import common.Constant;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    public static void main(String[] args) throws IOException {
        String filename = Constant.PATH_CHAPTER18_SECTION10 + "file/file_channel.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
//        FileChannel fc = new FileOutputStream(new File(filename).getAbsoluteFile()).getChannel();
        for (int i = 0; i < 1024; i++) {
            writer.write("a b c d ".toCharArray());
        }
        writer.close();
        System.out.println(new File(filename).length()/1024);
    }
}
