package level_3.hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static level_3.hw6.Main.getSubArrayAfterLastNumber;

class FirstMethodTests {
    static int[] sourceArr;

    @BeforeAll
    static void initArr() {
        sourceArr = new int[]{1, 5, 3, -8, 3, 0, 7, 2};
    }

    private static Stream<Arguments> multiData() {
        Random random = new Random();
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int[] source = getRandomArr(100);
            int numberPosition = random.nextInt(100);
            int number = source[numberPosition];
            int[] subArray = getSubArr(source, numberPosition);
            arguments.add(Arguments.arguments(source, number, subArray));
        }
        return arguments.stream();
    }

    private static int[] getRandomArr(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }

    private static int[] getSubArr(int[] arr, int position) {
        int[] subArr = new int[arr.length - position - 1];
        for (int i = position + 1, j = 0; i < arr.length; i++, j++) {
            subArr[j] = arr[i];
        }
        return subArr;
    }

    @Test
    void checkReturnArrayAfter3() {
        int[] expected = {0, 7, 2};
        int[] actual = getSubArrayAfterLastNumber(sourceArr, 3);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void checkReturnArrayAfter5() {
        int[] expected = {3, -8, 3, 0, 7, 2};
        int[] actual = getSubArrayAfterLastNumber(sourceArr, 5);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void checkReturnArrayAfterLastNumber() {
        int[] expected = {};
        int[] actual = getSubArrayAfterLastNumber(sourceArr, 2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void checkThrowExceptionWithAbsentNumber() {
        Assertions.assertThrows(RuntimeException.class, () -> getSubArrayAfterLastNumber(sourceArr, 4));
    }

    @ParameterizedTest
    @MethodSource("multiData")
    void multiTest(int[] source, int number, int[] expected) {
        int[] actual = getSubArrayAfterLastNumber(source, number);
        Assertions.assertArrayEquals(expected, actual);
    }
}