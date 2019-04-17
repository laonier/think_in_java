package chapter18.section1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern p = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return p.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static class FileTree implements Iterable<File>{
        private List<File> dirs = new ArrayList<>();
        private List<File> files = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(FileTree ft) {
            this.files.addAll(ft.files);
            this.dirs.addAll(ft.dirs);
        }
        public String toString() {
            Iterator<File> ite = files.iterator();
            if (!ite.hasNext()){
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            for (;;) {
                File f = ite.next();
                sb.append(f.getName());
                if (!ite.hasNext()){
                    return sb.toString();
                }
                sb.append("\n");
            }
        }
    }
    private static FileTree recursDir(File dir, String regex) {
        FileTree tree = new FileTree();
        for (File f: dir.listFiles()) {
            if (f.isDirectory()) {
                tree.dirs.add(f);
                tree.addAll(recursDir(f, regex));
            } else {
                if (f.getName().matches(regex))
                tree.files.add(f);
            }
        }
        return tree;
    }
    public static FileTree walk(String dir){
        return recursDir(new File(dir), ".*");
    }
    public static FileTree walk(String dir, String regex){
        return recursDir(new File(dir), regex);
    }

    public static void main(String[] args) {
        System.out.println(walk("./src", ".*\\.java"));
    }
}
