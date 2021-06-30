package alg.hw2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        bubbleSortTime(100_000);
        selectionSortTime(100_000);
        insertionSortTime(100_000);

    }

    private static MyArrayList<Integer> createRandomArr(int capacity) {
        MyArrayList<Integer> myList = new MyArrayList<>(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            myList.add(random.nextInt(capacity));
        }
        return myList;
    }

    private static void bubbleSortTime(int elements) {
        MyArrayList<Integer> myList = createRandomArr(elements);
        long start = System.currentTimeMillis();
        myList.bubbleSort();
        System.out.print("Bubble sorting time: ");
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static void selectionSortTime(int elements) {
        MyArrayList<Integer> myList = createRandomArr(elements);
        long start = System.currentTimeMillis();
        myList.selectionSort();
        System.out.print("Selection sorting time: ");
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static void insertionSortTime(int elements) {
        MyArrayList<Integer> myList = createRandomArr(elements);
        long start = System.currentTimeMillis();
        myList.insertionSort();
        System.out.print("Insertion sorting time: ");
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
