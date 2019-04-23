package chapter18.section7.exercises;

import chapter18.section7.BinaryFile;
import common.Constant;

import java.io.IOException;
import java.util.*;

public class E19_ByteCounter {
    public static void main(String[] args) {
        Map<Byte, Integer> counter = new HashMap<>();
        try {
            for (byte b: BinaryFile.read(Constant.PATH_CHAPTER18_SECTION07 + "exercises/E19_ByteCounter.java")) {
                int number = 1;
                if (counter.containsKey(b)) {
                    number += counter.get(b);
                }
                counter.put(b, number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Byte> bytes = new ArrayList<>(counter.keySet());
        bytes.sort(null);
        for (byte b: bytes) {
            System.out.println(b + " => " + counter.get(b));
        }
    }
}
