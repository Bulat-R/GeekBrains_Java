/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла
   и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить
   его диагональные элементы единицами;
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в
   массиве есть место, в котором сумма левой и правой части массива равны.
   Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана
   символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
   при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
   пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
   при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
*/

package level_1.hw2;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {

        // Задание №1
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(arr1));

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0 ? 1 : 0);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        // Задание №2
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        // Задание №3
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(arr3));

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        // Задание №4
        int[][] arr4 = new int[10][10];
        for (int i = 0, j = arr4.length - 1; i < arr4.length; i++, j--) {
            arr4[i][j] = 1;
        }
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println();

        // Задание №5
        int [] arr5 = { 1, -5, 5, 9, 6, 8, 20, 4};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : arr5) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        System.out.println(Arrays.toString(arr5));
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println();

        // Задание №6
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 12, 1}));
        System.out.println();

        // Задание №7
        int [] arr7 = { 1, 5, -2, 9, 6, 8, 20, 4};
        System.out.println(Arrays.toString(arr7));
        moveArray(arr7, 5);
        System.out.println(Arrays.toString(arr7));
        moveArray(arr7, -5);
        System.out.println(Arrays.toString(arr7));
    }

    private static boolean checkBalance(int[] arr) {
        if (arr.length < 1) {
            return false;
        }

        int summ = 0;
        for (int x : arr) {
            summ += x;
        }

        if (summ % 2 != 0) {
            return false;
        }

        int temp = 0;
        for (int x : arr) {
            temp += x;
            if (temp == summ / 2) {
                return true;
            }
        }
        return false;
    }

    private static void moveArray(int[] arr, int n) {
        int step = n % arr.length;
        if (step == 0) {
            return;
        }

        step = (arr.length - step) % arr.length;

        for (int i = 0; i < step; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

