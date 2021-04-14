package level_2.hw5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    private static void firstMethod() {
        long start = System.currentTimeMillis();
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        changeArr(arr);
        long end = System.currentTimeMillis();
        System.out.println("firstMethod time: " + (end - start) + " ms");
    }

    private static void secondMethod() throws InterruptedException {
        long start = System.currentTimeMillis();
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        int half = size / 2;
        float[] arr1 = new float[half];
        float[] arr2 = new float[size - half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, size - half);

        Thread t1 = new Thread(() -> changeArr(arr1));
        Thread t2 = new Thread(() -> changeArr(arr2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        long end = System.currentTimeMillis();
        System.out.println("secondMethod time: " + (end - start) + " ms");
    }

    private static void changeArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
