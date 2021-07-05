package alg.hw3;

import java.util.Arrays;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int right;
    private int left;
    private final double RESIZE_FACTOR = 1.5;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T element) {
        if (isFull()) {
            resize();
        }
        list[right] = element;
        size++;
        right = getRightNextIndex();
    }

    public void insertLeft(T element) {
        if (isFull()) {
            resize();
        }
        list[getLeftNextIndex()] = element;
        size++;
        left = getLeftNextIndex();
    }

    private void resize() {
        T[] newList = (T[]) new Object[(int) (list.length * RESIZE_FACTOR)];
        for (int i = 0; i < size; i++) {
            int j = (right + i) % list.length;
            newList[i] = list[j];
        }
        list = newList;
        right = size;
        left = 0;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        T element = list[getRightPrevIndex()];
        list[getRightPrevIndex()] = null;
        right = getRightPrevIndex();
        size--;
        return element;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        T element = list[left];
        list[left] = null;
        left = getLeftPrevIndex();
        size--;
        return element;
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return list[getRightPrevIndex()];
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return list[left];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == list.length;
    }

    private int getRightNextIndex() {
        return (right + 1) % list.length;
    }

    private int getRightPrevIndex() {
        return (right - 1 + list.length) % list.length;
    }

    private int getLeftNextIndex() {
        return (left - 1 + list.length) % list.length;
    }

    private int getLeftPrevIndex() {
        return (left + 1) % list.length;
    }

    public String toString() {
        return Arrays.toString(list) + "r=" + right + " l=" + left;
    }
}
