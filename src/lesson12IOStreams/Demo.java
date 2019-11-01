package lesson12IOStreams;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        runTask1();
        runTask2();
    }

    private static void runTask1() {
        System.out.println("Создать и заполнить файл случайными целыми числами. " +
                "Отсортировать содержимое файла по возрастанию. " +
                "По итогу получить файл с отсортированным массивом чисел");

        String fileName = "textWriterTask1.txt";
        int countElement = 30;
        int boundRandomInt = 1000;

        utils.FileUtils.writeFileWithRandomInt(fileName, countElement, boundRandomInt);

        List<Integer> list = utils.FileUtils.getSortListIntFromFile(fileName);

        fileName = "textWriterTask1SortInt.txt";
        utils.FileUtils.writeFileIntFromList(list, fileName);

    }

    private static void runTask2() {
        System.out.println("Прочитать строки из файла и поменять местами " +
                "первое и последнее слова в каждой строк.");

    }

    private static void runTask3() {
        System.out.println("Разместить в файле любой текст, разбить его на абзацы, " +
                "предложения, слова, вывести статистику по тексту. " +
                "Ко всему этому использовать паттерн Chain of Responsibilities.");
    }


}