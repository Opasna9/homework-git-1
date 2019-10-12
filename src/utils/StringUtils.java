package utils;

import static utils.ArrayUtils.sortBubbleArray;

public class StringUtils {

    public static String deleteIncludeSymbols(String stringIn, String symbolStart, String symbolEnd) {
        if (symbolStart.equals(symbolEnd)) {
            return deleteIncludeSymbols(stringIn, symbolStart);
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

    public static String deleteIncludeSymbols(String stringIn, String symbol) {
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

    public static int countVolwelsRU(String s) {
        if (s == null) {
            return 0;
        }
        return s.toLowerCase().replaceAll("[^аяуюиыэеоеё]", "").length();
    }

    public static int countConsonantRU(String s) {
        if (s == null) {
            return 0;
        }
        return s.toLowerCase().replaceAll("[^а-я]", "").replaceAll("[аяуюиыэеоеё]", "").length();
    }

    public static boolean isVowelRU(char symbol) {
        char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
        symbol = Character.toLowerCase(symbol);
        for (char vowel : vowels) {
            if (symbol == vowel)
                return true;
        }
        return false;
    }

    public static String[] getInterrogativeSentences(String text) {
        String[] result;
        boolean isLastSymbolQuestion = false;
        if (text.endsWith("?")) {
            isLastSymbolQuestion = true;
        }
        String[] stringEndsQuestion = text.split("[\\?]");
        if (isLastSymbolQuestion) {
            result = new String[stringEndsQuestion.length];
        } else {
            result = new String[stringEndsQuestion.length - 1];
        }
        int countRes = 0;

        for (int i = stringEndsQuestion.length - 1; i >= 0; i--) {
            if ((i == 0 && isLastSymbolQuestion) || (i != 0)) {
                //System.out.println(stringEndsQuestion[i] + "?");
                String[] questions = stringEndsQuestion[i].split("[\\.\\!]");
                for (int j = questions.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        //System.out.println(questions[j] + "?");
                        result[countRes++] = questions[j].trim();
                    }
                }
            }
        }
        return result;
    }

    public static String[] getWordsUniqueByLenght(String s, int lenght) {
        String[] words = sortBubbleArray(s.toLowerCase().replaceAll("[^а-я ]", "").split(" "));
        int lenghtNew = 0;
        String prevValue = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == lenght) {
                if (!prevValue.equals(words[i])) {
                    lenghtNew++;
                    prevValue = words[i];
                }
            }
        }
        String[] result = new String[lenghtNew];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == lenght) {
                if (!prevValue.equals(words[i])) {
                    result[j++] = words[i];
                    prevValue = words[i];
                }
            }
        }
        return result;
    }
}
