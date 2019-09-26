package lesson1;

import java.util.Random;

public class DataRandom {
    private static final Random RANDOM = new Random();

    private DataRandom() {
        throw new IllegalStateException("Utility class");
    }

    static Random getRANDOM() {
        return RANDOM;
    }

    static double[] createRandomArray(int length, int bound) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(bound);
        }
        return array;
    }

    public static int[] createRandomArrayInt(int length, int bound) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(bound);
        }
        return array;
    }

}
