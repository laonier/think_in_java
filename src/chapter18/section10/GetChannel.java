package chapter18.section10;

import common.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    public static void main(String[] args) throws IOException {
        String filename = Constant.PATH_CHAPTER18_SECTION10 + "file/file_channel.txt";
        FileChannel fc = new FileInputStream(new File(filename).getAbsoluteFile()).getChannel();
        fc.write(ByteBuffer.wrap("something ".getBytes()));
    }
}
