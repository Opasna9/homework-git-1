package lesson6Strings;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.sortBubbleArray;

public class Demo {
    public static void main(String[] args) {
        String stringIn = "Более 30 тысяч пользователей «Авто барахолки» ждали 11 октября. " +
                "Ведь именно сегодня состоится розыгрыш автомобиля *Hyundai Accent*. " +
                "В конкурсе приняли участие 32096 объявлений, которые соответствовали правилам. " +
                "Сегодня, примерно в 12:30, мы узнаем победителя. " +
                "«Трансляция» розыгрыша будет вестись прямо в данной заметке, поэтому не *спешите* ее закрывать узнаем .";
        runTask1(stringIn);
        runTask2(stringIn);
        runTask3(stringIn);
        runTask4(stringIn);
        runTask5(stringIn);
        runTask6(stringIn);
        runTask7(stringIn);
        runTask8();
    }

    private static void runTask1(String stringIn) {
        System.out.println("1. Преобразовать текст так, чтобы каждое слово начиналось с заглавной буквы.");
        System.out.println("String in = " + stringIn);
        String stringOut = "";
        String[] sArray = stringIn.split("");
        //printArray(sArray);
        for (int i = 0; i < sArray.length; i++) {
            if (i == 0) {
                sArray[0] = sArray[0].toUpperCase();
            } else if (sArray[i - 1].equals("\u00a0") || sArray[i - 1].equals(" ")) {
                sArray[i] = sArray[i].toUpperCase();
            }
            stringOut += sArray[i];
        }
        //System.out.println("String out = " + stringOut);
    }

    private static void runTask2(String stringIn) {
        System.out.println("\n2. Подсчитать количество содержащихся в данном тексте знаков препинания");
        String stringWithoutPunct;
        stringWithoutPunct = stringIn.replaceAll("\\p{Punct}", "");
        System.out.println("stringWithoutPunct = " + stringWithoutPunct);
        System.out.println("Namber of punct = " + (stringIn.length() - stringWithoutPunct.length()));
    }

    private static void runTask3(String stringIn) {
        System.out.println("\n3.  Определить сумму всех целых чисел, встречающихся в заданном тексте");
        String[] sArray = stringIn.split(" ");
        int sumValues = 0;
        String valuesInt = "";
        //printArray(sArray);
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == sArray[i].replaceAll("[^0-9]", "")) {
                sumValues = +Integer.parseInt(sArray[i]);
                valuesInt += Integer.parseInt(sArray[i]) + " ";
            }
        }
        System.out.println("valuesInt = " + valuesInt);
        System.out.println("sumValues = " + sumValues);
    }

    private static void runTask4(String stringIn) {
        System.out.println("\n4. В каждом слове текста k-ю букву заменить заданным символом. Если  k больше длины слова, корректировку не выполнять.");
        String[] sArray = stringIn.split(" ");
        int k = 5;
        String symbol = "#";
        String stringOut = "";
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].length() >= k) {
                stringOut += sArray[i].substring(0, k - 1) + symbol;
                if (sArray[i].length() > k) {
                    stringOut += sArray[i].substring(k, sArray[i].length());
                }
                stringOut += " ";

            } else {
                stringOut += sArray[i] + " ";
            }
        }
        stringOut = stringOut.trim();
        System.out.println(stringOut);
    }

    private static void runTask5(String stringIn) {
        System.out.println("\n5. Удалить из текста его часть, заключенную между двумя символами, которые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).");
        String symbolStart = "«";
        String symbolEnd = "»";
        String symbol = "*";
        System.out.println("deleteIncludeSymbols '" + symbolStart + "' and '" + symbolEnd + "'");
        System.out.println(deleteIncludeSymbols(stringIn, symbolStart, symbolEnd));
        System.out.println("deleteIncludeSymbols '" + symbol + "'");
        System.out.println(deleteIncludeSymbols(stringIn, symbol));
        System.out.println(deleteIncludeSymbols(stringIn, symbol, symbol));
    }

    private static String deleteIncludeSymbols(String stringIn, String symbolStart, String symbolEnd) {
        if (symbolStart.equals(symbolEnd)){
            return deleteIncludeSymbols(stringIn,symbolStart);
        }
        String stringOut = stringIn;
        String[] sArray = stringIn.split("");
        String stringDel;
        int start = 0; // symbol position in string
        int end = 0; // symbol position in ending
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals(symbolStart)) {
                start = i;
            } else if (sArray[i].equals(symbolEnd)) {
                end = i;
            }
            if (end > start) {
//                System.out.println(stringIn.substring(start + 1, end));
                stringDel = symbolStart + stringIn.substring(start + 1, end) + symbolEnd;
                stringOut = stringOut.replace(stringDel, (symbolStart + symbolEnd));
                start = 0;
                end = 0;
            }
        }
        return stringOut;
    }

    private static String deleteIncludeSymbols(String stringIn, String symbol) {
        String[] sArray = stringIn.split("");
        String stringDel;
        String stringOut = stringIn;
        int start = 0; // symbol position in string
        int end = 0; // symbol position in ending
        int position = 0; // symbol position
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals(symbol)) {
                position++;
                if (position % 2 == 1) {
                    start = i;
                } else {
                    end = i;
//                    System.out.print("start = " + start);
//                    System.out.println(" end = " + end);
                    stringDel = symbol + stringIn.substring(start + 1, end) + symbol;
                    stringOut = stringOut.replace(stringDel, (symbol + symbol));
                    start = 0;
                    end = 0;
                }
            }
        }
        return stringOut;
    }

    private static void runTask6(String stringIn) {
        System.out.println("\n6.  Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.");
        String[] sArray = sortBubbleArray(stringIn.toLowerCase().replaceAll("\\p{Punct}", "").split(" "));
        printArray(sArray);
        int count = 0;
        String distinctResult = "";
        for (int i = 0; i < sArray.length; i++) {
            if (i < sArray.length - 1){
                if (sArray[i].equals(sArray[i+1])){
                    count++;
                } else {
                    count++;
                    System.out.println(count + " : " + sArray[i]);
                    count = 0;
                }
            }
        }
    }

    private static void runTask7(String stringIn) {
        System.out.println("\n7. Найти, каких букв, гласных или согласных, больше в каждом предложении текста");
        // каждое предложение текста разобрать
        stringIn = stringIn.replaceAll("[^а-яА-Я]", "");
        char[] chars = stringIn.toCharArray();
        int countVolwels = 0;
        int countConsonant = 0;
        for (char aChar : chars) {
            if (isVowel(aChar)){
                countVolwels++;
            } else {
                countConsonant++;
            }
        }
        System.out.println("countVolwels = " + countVolwels + " countConsonant = " + countConsonant);
    }

    private static boolean isVowel(char symbol)
    {
        char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
        symbol = Character.toLowerCase(symbol);
        for (char vowel : vowels)
        {
            if (symbol == vowel)
                return true;
        }
        return false;
    }

    private static void runTask8() {
        System.out.println("\n8. Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины");
    }

}
