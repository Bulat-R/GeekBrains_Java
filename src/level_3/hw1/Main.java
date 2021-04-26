package level_3.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] strings = {"one", "two", "three", "four"};
        System.out.println(Arrays.toString(changeValues(strings, 1, 3)));
        List<String> stringList = arrayToList(strings);
        System.out.println(stringList);
        System.out.println(stringList.getClass().getSimpleName());

        Box<Orange> orangeBox1 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        for (int i = 0; i < 10; i++) {
            orangeBox1.put(new Orange());
            appleBox1.put(new Apple());
            appleBox2.put(new Apple());

        }

        System.out.println(orangeBox1.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(appleBox1.compare(orangeBox1));
        System.out.println(appleBox1.compare(appleBox2));

        appleBox1.transfer(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());

    }

    public static <T> T[] changeValues(T[] arr, int firstInd, int secondIndex) {
        try {
            T tmp = arr[firstInd];
            arr[firstInd] = arr[secondIndex];
            arr[secondIndex] = tmp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid indexes");
        }
        return arr;
    }

    public static <T> ArrayList<T> arrayToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
