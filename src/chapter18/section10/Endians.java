package chapter18.section10;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Endians {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(3*8);
        bb.asLongBuffer().put(10).put(10);
        System.out.println(bb.position());
        bb.asLongBuffer();
        System.out.println(bb.position());
        System.out.println(Arrays.toString(bb.array()));
    }
}
