package conspect.oop.sream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class IODemo {
    public static void main(String[] args) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter = null;
        try (FileWriter testWriter = new FileWriter("test2.txt")) {
            // лучше все ресурсы в try параметр, чтобы блок с close() не писать
            fileWriter = new FileWriter("test.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            //Decorator
            printWriter.println("Hello new file!");

            testWriter.write("Hello!");

            String s = "qweqweqwe";
            char[] chars = s.toCharArray();
            System.out.println("123123123");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }

    }
}
