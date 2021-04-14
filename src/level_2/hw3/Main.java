package level_2.hw3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //-------Задание №1-------
        String[] someWords = { "one", "two", "three", "four", "five", "six" };
        String[] randomArr = getRandomArray(someWords, 20);
        System.out.println(Arrays.toString(randomArr));
        System.out.println(countTheWords(randomArr));

        //-------Задание №2-------
        PhoneBook book = new PhoneBook();
        book.add("Иван", "1234567");
        book.add("Иван", "2345678");
        book.add("Вася", "4567890");
        System.out.println(book.get("Иван"));
        System.out.println(book.get("Вася"));
        System.out.println(book.get("Bob"));

        //-------Stream, Lambda?-------
        List<String> list = Arrays.asList(randomArr);
        System.out.println(list.stream().collect(Collectors.joining(" | ")));
        Map<String, Integer> map = new HashMap<>();
        list.forEach(key -> map.merge(key, 1, Integer::sum));
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    private static String[] getRandomArray(String[] arr, int size) {
        Random random = new Random();
        String[] randomArr = new String[size];
        for (int i = 0; i < size; i++) {
            randomArr[i] = arr[random.nextInt(arr.length)];
        }
        return randomArr;
    }

    private static Map<String, Integer> countTheWords(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map;
    }
}
