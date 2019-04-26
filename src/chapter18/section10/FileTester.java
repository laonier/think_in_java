package chapter18.section10;

import common.Constant;
import common.Tester;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public abstract class FileTester {
    private String description;
    public FileTester(String description) {
        this.description = description;
    }
    public void runTest() {
        long start = System.currentTimeMillis();
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(description + " : " + duration);
    }
    public abstract void test() throws IOException;
    private static int READ_TIMES = 10000;
    private static int WRITE_TIMES = 1000000;
    private static String FILENAME = Constant.PATH_CHAPTER18_SECTION10 + "file/read.txt";
    private static String WRITE_FILENAME = "D:/write.txt";
    private static FileTester[] testers = new FileTester[]{
            new FileTester("Buffered Read") {
                @Override
                public void test() throws IOException{
                    BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                    for (int i = 0; i < READ_TIMES; i ++) {
                        reader.read();
                    }
                }
            },
            new FileTester("Mapped Read") {
                @Override
                public void test() throws IOException{
                    FileChannel fc = new RandomAccessFile(new File(FILENAME).getAbsoluteFile(), "rw").getChannel();
                    MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, READ_TIMES);
                    for (int i = 0; i < READ_TIMES; i++) {
                        mbb.get();
                    }
                }
            },
            new FileTester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream out = new DataInputStream(new FileInputStream(FILENAME));
                    for (int i = 0; i < READ_TIMES; i++) {
                        out.read();
                    }
                }
            },
            new FileTester("Buffered Write") {
                @Override
                public void test() throws IOException {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(WRITE_FILENAME));
                    for (int i = 0; i < WRITE_TIMES; i++) {
                        writer.write('A');
                    }
                    writer.close();
                }
            },
            new FileTester("Stream Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream out = new DataOutputStream(new FileOutputStream(WRITE_FILENAME));
                    for (int i = 0; i < WRITE_TIMES; i++) {
                        out.write('x');
                    }
                    out.close();
                }
            },
            new FileTester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File(WRITE_FILENAME).getAbsoluteFile(), "rw").getChannel();
                    MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, WRITE_TIMES);
                    for (int i = 0; i < WRITE_TIMES; i++) {
                        mbb.put(ByteBuffer.wrap("A".getBytes()));
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for(FileTester ft: testers) {
            ft.runTest();
        }
    }
}
