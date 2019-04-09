package chapter18.section1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class FileList {
    public static void main(String[] args) {
        File file = new File("./src/chapter18/section1/file");
        String[] fileList = file.list();
        Arrays.sort(fileList, String.CASE_INSENSITIVE_ORDER);
        for(String name: fileList)
        System.out.println(name);
    }
}
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String rex){
        pattern = Pattern.compile(rex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
