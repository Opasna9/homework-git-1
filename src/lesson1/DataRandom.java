package lesson1;

import java.util.Random;

public class DataRandom {
    private static final Random RANDOM = new Random();

    public static Random getRANDOM() {
        return RANDOM;
    }

    public static double[] createRandomArray(int length, int bound) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(bound);
            if (i != array.length - 1) {
            }
        }
        return array;
    }

    public static int[] createRandomArrayInt(int length, int bound) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(bound);
            if (i != array.length - 1) {
            }
        }
        return array;
    }

}
