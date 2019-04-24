package chapter18.section9;

import common.Constant;

import java.io.*;

public class OSExecute {
    public static void command(String command) {
        command(command, "");
    }
    public static void command(String command, String directory) {
        try {
            ProcessBuilder builder = new ProcessBuilder(command.split(" "));
            File file = builder.directory();
            if (directory != null && directory.trim().length() > 0) {
                file = new File(directory).getAbsoluteFile();
            }
            builder.directory(file);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String buf;
            System.out.println("process.getInputStream: ");
            while ((buf = reader.readLine()) != null) {
                System.out.println(buf);
            }
            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), "GBK"));
            System.out.println("process.getErrorStream: ");
            while ((buf = errorReader.readLine()) != null) {
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        command("javap OSExecute", "D:\\git\\think_in_java\\out\\classes\\chapter18\\section9");
    }
}
