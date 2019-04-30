package chapter18.section10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream file = new FileOutputStream("D:\\write.txt", true);
        file.getChannel();
        FileLock lock = file.getChannel().tryLock();
        if (lock != null) {
            System.out.println("File locking");
            TimeUnit.SECONDS.sleep(30);
            lock.release();
            System.out.println("File release");
        }
        file.close();
    }
}
