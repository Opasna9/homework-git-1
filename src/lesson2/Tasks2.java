package lesson2;

import lesson1.DataPrint;
import lesson1.DataRandom;

public class Tasks2 {
    public static void main(String[] args) {
        System.out.println("lesson2\n");
        runTask1();
        runTask2();
        runTask3();
        runTask4();
        runTask5();
        runTask6();
        runTask7();
        runTask8();
        runTask9();
        runTask10();
        runTask11();
        runTask12();
        runTask13();
        runTask14();
        runTask15();
        runTask16();
        runTask17();
        runTask18();
        runTask19();
        runTask20();
    }

    private static void runTask1() {
        System.out.println("Task 1. Write a Java program to sort a numeric array and a string array.");
        sortBubbleNumericArray();
        sortBubbleStringArray();
    }

    private static void sortBubbleNumericArray() {
        int length = 10;
        int bound = 100;
        int[] array = DataRandom.createRandomArrayInt(length,bound);
        int temp = 0;
        DataPrint.printArray(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = (array.length - 1); j >= (i + 1); j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        DataPrint.printArray(array);
    }

    private static void sortBubbleStringArray() {
        String[] array = {"Io", "Sven", "Tiny", "Void", "Mirana", "Riki", "CM", "Lina"};
        DataPrint.printArray(array);
        String temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = (array.length - 1); j >= (i + 1); j--) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        DataPrint.printArray(array);
    }

    private static void runTask2() {
        System.out.println("\nTask 2. Write a Java program to sum values of an array.");
        int length = 10;
        int bound = 100;
        int[] array = DataRandom.createRandomArrayInt(length, bound);
        int sum = 0;
        DataPrint.printArray(array);
        for (int i : array) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    private static void runTask3() {
        System.out.println("\nTask 3. Write a Java program to print the following grid");
    }

    private static void runTask4() {
        System.out.println("\nTask 4.  Write a Java program to calculate the average value of array elements.");
        int length = 10;
        int bound = 100;
        int[] array = DataRandom.createRandomArrayInt(length, bound);
        double averageValue = 0;
        DataPrint.printArray(array);
        for (int i : array) {
            averageValue += i;
        }
        System.out.println("averageValue = " + averageValue / array.length);
    }

    private static void runTask5() {
        System.out.println("\nTask 5.  Write a Java program to test if an array contains a specific value.");
        int length = 8;
        int bound = 10;
        int[] array = DataRandom.createRandomArrayInt(length, bound);
        int value = 5;
        boolean containsSpecificValue = false;
        DataPrint.printArray(array);
        for (int i : array) {
            if (i == value) {
                containsSpecificValue = true;
            }
        }
        if (containsSpecificValue) {
            System.out.println("Array contains a specific value = " + value);
        } else {
            System.out.println("Array not contains a specific value = " + value);
        }
    }

    private static void runTask6() {
        System.out.println("\nTask 6.  Write a Java program to find the index of an array element.");
        int[] array = DataRandom.createRandomArrayInt(10, 100);
        DataPrint.printArray(array);
        int index = 6;
        if ((index < array.length) && (index >= 0)){
            System.out.println("index = " + index + " value = " + array[index]);
        } else {
            System.out.println("index = " + index + " Not found in array!");
        }
    }

    private static void runTask7() {
        System.out.println("\nTask 7.  Write a Java program to remove a specific element from an array.");
        int[] array = {5,0,5,5,6,7,8,4,5};
        int value = 5;
        DataPrint.printArray(array);
        int j = 0;
        int countWithoutValue = 0;
        for (int i : array) {
            if (i != value){
                countWithoutValue++;
            }
        }
        int[] newArray = new int[countWithoutValue];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != value){
                newArray[j] = array[i];
                j++;
            }
        }
        DataPrint.printArray(newArray);
    }

    private static void runTask8() {
        System.out.println("\nTask 8.  Write a Java program to copy an array by iterating the array.");
        int length = 20;
        int bound = 100;
        int[] array = DataRandom.createRandomArrayInt(length, bound);
        System.out.print("array = ");
        DataPrint.printArray(array);
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        System.out.print("newArray = ");
        DataPrint.printArray(array);
    }

    private static void runTask9() {
        System.out.println("\nTask 9.  Write a Java program to insert an element (specific position) into an array.");
    }

    private static void runTask10() {
        System.out.println("\nTask 10. Write a Java program to find the maximum and minimum value of an array.");
    }

    private static void runTask11() {
        System.out.println("\nTask 11. Write a Java program to reverse an array of integer values.");
    }

    private static void runTask12() {
        System.out.println("\nTask 12. Write a Java program to find the duplicate values of an array of integer values.");
    }

    private static void runTask13() {
        System.out.println("\nTask 13. Write a Java program to find the duplicate values of an array of string values.");
    }

    private static void runTask14() {
        System.out.println("\nTask 14. Write a Java program to find the common elements between two arrays (string values).");
    }

    private static void runTask15() {
        System.out.println("\nTask 15. Write a Java program to find the common elements between two arrays of integers.");
    }

    private static void runTask16() {
        System.out.println("\nTask 16. Write a Java program to remove duplicate elements from an array.");
    }

    private static void runTask17() {
        System.out.println("\nTask 17. Write a Java program to find the second largest element in an array.");
    }

    private static void runTask18() {
        System.out.println("\nTask 18. Write a Java program to find the second smallest element in an array.");
    }

    private static void runTask19() {
        System.out.println("\nTask 19. Write a Java program to add two matrices of the same size.");
    }

    private static void runTask20() {
        System.out.println("\nTask 20. Write a Java program to convert an array to ArrayList.");
    }
}
