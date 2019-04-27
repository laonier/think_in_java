package chapter18.section11;

import common.Constant;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress {

    public static void main(String[] args) {
        String filename = Constant.PATH_CHAPTER18_SECTION11 + "file/out.gz";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedOutputStream out = new BufferedOutputStream(
                     new GZIPOutputStream(new FileOutputStream(filename)))) {
            String buf;
            while (!(buf = reader.readLine()).equals("end")) {
                out.write(buf.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader1 = new BufferedReader(
                     new InputStreamReader(new GZIPInputStream(new FileInputStream(filename))))) {
            String buf;
            while ((buf = reader1.readLine()) != null) {
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
