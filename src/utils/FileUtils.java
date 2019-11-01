package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtils {

    private static final Random rnd = new Random();

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void writeFileIntFromList(List<Integer> list, String fileName) {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            for (Integer integer : list) {
                pw.println(integer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileWithRandomInt(String fileName, int countElement, int boundRandomInt) {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            for (int i = 0; i < countElement; i++) {
                pw.println(rnd.nextInt(boundRandomInt));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getSortListIntFromFile(String fileName) {
        List<Integer> list = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr);) {

            int ch;
            String str;
            while ((str = br.readLine()) != null) {
                ch = Integer.parseInt(str);
                list.add(ch);
            }

            list.sort(Integer::compareTo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
