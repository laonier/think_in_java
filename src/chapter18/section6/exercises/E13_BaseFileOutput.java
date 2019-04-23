package chapter18.section6.exercises;

import common.Constant;

import java.io.*;

public class E13_BaseFileOutput {
    public static void main(String[] args) throws Exception {
        int runMaxTimes = 10000000;
        String bufferedDestination = Constant.PATH_CHAPTER18_SECTION06 + "/exercises/buffer.out";
        String noneBufferedDestination = Constant.PATH_CHAPTER18_SECTION06 + "/exercises/none_buffer.out";
        String content = "生命总是在不经意直接惊艳了你。";
        PrintWriter bw = new PrintWriter(bufferedDestination);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < runMaxTimes; i++) {
            bw.println(content);
        }
        bw.close();
        long time2 = System.currentTimeMillis();
        PrintWriter w = new PrintWriter(new FileWriter(noneBufferedDestination));
        for (int i = 0; i < runMaxTimes; i++) {
            w.println(content);
        }
        w.close();
        long time3 = System.currentTimeMillis();
        System.out.println("buffered write time: " + (time2 - time1));
        System.out.println("none buffered write time: " + (time3 - time2));
    }
}
