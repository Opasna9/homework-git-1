package lesson12IOStreams;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        runTask1();
        runTask2();
        runTask3();
    }

    private static void runTask1() {
        System.out.println("1. Создать и заполнить файл случайными целыми числами.\n" +
                "Отсортировать содержимое файла по возрастанию.\n" +
                "По итогу получить файл с отсортированным массивом чисел");

        String fileName = "textWriterTask1.txt";
        int countElement = 30;
        int boundRandomInt = 1000;

        utils.FileUtils.writeFileWithRandomInt(fileName, countElement, boundRandomInt);

        List<Integer> list = utils.FileUtils.getSortListIntFromFile(fileName);

        fileName = "textWriterTask1SortInt.txt";
        utils.FileUtils.writeFileIntFromList(list, fileName);

        System.out.println("created files: textWriterTask1.txt, textWriterTask1SortInt.txt\n");
    }

    private static void runTask2() {
        System.out.println("2. Прочитать строки из файла и поменять местами " +
                "первое и последнее слова в каждой строк.");

        String fileInName = "fileInTask2.txt";
        String text = "один два три\n" +
                "один два три\n" +
                "один два три\n" +
                "один два три\n" +
                "один два три";
        String encoding = "UTF-8";

        utils.FileUtils.writeFile(fileInName, text, encoding);

        String fileOutName = "textWriterTask2Swap.txt";

        utils.FileUtils.copyFileSwapFirstLastWordAtLine(fileInName, fileOutName);

        System.out.println("created files: fileInTask2.txt, textWriterTask2Swap.txt\n");

    }

    private static void runTask3() {
        System.out.println("3. Разместить в файле любой текст, разбить его на абзацы, " +
                "предложения, слова, вывести статистику по тексту.\n" +
                "Ко всему этому использовать паттерн Chain of Responsibilities.");

        String fileInName = "fileInTask3.txt";
        String text = "Таиландское издание The Phuket News сообщило, что белорус Максим Щарцов приехал со своей женой в отпуск на Пхукет. 30 октября он купался в море и пропал без вести — девушка забила тревогу. Утром 2 ноября тело белоруса нашли у скалы. Супруга погибшего Ирина Рослик рассказала Onliner, как все случилось.\n" +
                "«Той же ночью (30 октября. — Прим. Onliner) был начат поиск, но спасатели не смогли найти туриста в темноте. Поисковые работы продолжались каждый день с участием множества местных спасательных агентств, добровольцев и офицеров. Королевский флот Таиланда выделил вертолет, чтобы прочесывать море с воздуха», — написали в The Phuket News. Около 7:45 утра 2 ноября поисковая группа обнаружила тело туриста, которое отвезли в больницу.\n" +
                "«Хотя официального подтверждения еще нет, это тело мужчины примерно того же возраста, что и Максим Щарцов. На нем такие же плавки, в каких в последний раз видели господина Щарцова, когда он плавал», — говорится в сообщении.\n" +
                "По словам местной полиции, 29-летняя Ирина оставалась на острове, пока шли поиски.\n" +
                "«Офицеры из Центра помощи туристам и Туристической полиции Пхукета поддерживают ее, помогая поддерживать связь с ее семьей и консульскими должностными лицами», — говорил ранее майор из Пхукетской туристической полиции.";
        String encoding = "UTF-8";

        utils.FileUtils.writeFile(fileInName, text, encoding);

        StringBuilder sb = new StringBuilder();

        try (FileReader fr = new FileReader(fileInName);
             BufferedReader br = new BufferedReader(fr);) {

            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString().trim());




    }


}