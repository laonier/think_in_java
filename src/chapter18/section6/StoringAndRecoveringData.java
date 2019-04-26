package chapter18.section6;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws Exception {
        String file = "./src/chapter18/section6/warehouse.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)));
        out.writeBoolean(true);
        out.writeChars("C");
        out.writeUTF("UTF");
        out.writeFloat(1.444f);
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readBoolean());
        System.out.println(in.readChar());
        System.out.println(in.readUTF());
        System.out.println(in.readFloat());
    }
}
