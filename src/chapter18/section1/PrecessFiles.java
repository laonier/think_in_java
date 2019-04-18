package chapter18.section1;

import java.io.File;

/**
 * 策略设计模式.
 */
public class PrecessFiles {
    public interface Strategy<T> {
        void process(T t);
    }
    private Strategy<File> strategy;
    private String ext;
    public PrecessFiles(Strategy<File> str, String ext){
        this.strategy = str;
        this.ext = ext;
    }
    private void processDirectoryTree(File root) {
        for (File file: Directory.walk(root.getAbsolutePath(), ".*\\." + ext)){
            strategy.process(file);
        }
    }
    public void start(String path) {
        processDirectoryTree(new File(path));
    }

    public static void main(String[] args) {
        new PrecessFiles(new Strategy<File>() {
            @Override
            public void process(File file) {
                System.out.println(file.getName());
            }
        }, "java").start(".");
    }
}
