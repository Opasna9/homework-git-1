package lesson1Operator;

public class DataPrint {

    public static void printArray(double[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(String[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(int[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(Object[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}
