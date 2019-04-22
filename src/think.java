import java.io.File;
import java.io.IOException;

public class think {
    public static void main(String[] args) {
        String path = "./src/think.java";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
