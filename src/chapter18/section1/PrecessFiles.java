package chapter18.section1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 策略设计模式.
 */
public class PrecessFiles {
    public interface Strategy {
        void process(File t);
    }
    private Strategy strategy;
    private String ext;
    public PrecessFiles(Strategy str, String ext){
        this.strategy = str;
        this.ext = ext;
    }
    private void processDirectoryTree(File root) throws IOException {
        for (File file: Directory.walk(root.getCanonicalPath(), ".*\\." + ext)){
            strategy.process(file);
        }
    }
    public void start(String path) {
        try {
            processDirectoryTree(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Long> sizeList = new ArrayList<>();
        new PrecessFiles(new Strategy() {
            @Override
            public void process(File file) {
                sizeList.add(file.getFreeSpace());
            }
        }, "java").start(".");
    }
}
