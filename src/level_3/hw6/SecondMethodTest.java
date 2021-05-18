package level_3.hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static level_3.hw6.Main.isArrOfThisNumbers;

public class SecondMethodTest {

    @Test
    void arrayWith2Numbers() {
        int[] arr = new int[]{1, 4, 4, 4, 1, 1, 4, 1, 1};
        Assertions.assertTrue(isArrOfThisNumbers(arr, 1, 4));
    }

    @Test
    void arrayWith1Number() {
        int[] arr = new int[]{4, 4, 4, 4, 4, 4, 4, 4};
        Assertions.assertTrue(isArrOfThisNumbers(arr, 4));
    }

    @Test
    void absentOneNumberInParameters() {
        int[] arr = new int[]{1, 2, 3, 4, 1, 1, 4, 1, 1};
        Assertions.assertFalse(isArrOfThisNumbers(arr, 1, 2, 3));
    }

    @Test
    void absentOneNumberInArray() {
        int[] arr = new int[]{2, 4, 4, 2, 2, 2, 4, 2, 2};
        Assertions.assertFalse(isArrOfThisNumbers(arr, 2, 4, 5));
    }

    @Test
    void absentAllNumbersInArray() {
        int[] arr = new int[]{1, 4, 4, 4, 1, 1, 4, 1, 1};
        Assertions.assertFalse(isArrOfThisNumbers(arr, 2, 3, 5));
    }

    @Test
    void emptyArray() {
        int[] arr = new int[0];
        Assertions.assertFalse(isArrOfThisNumbers(arr, 9));
    }

    @Test
    void nullArray() {
        Assertions.assertThrows(NullPointerException.class, () -> isArrOfThisNumbers(null, 8, 7));
    }

    @Test
    void nullNumbers() {
        int[] arr = new int[]{1, 4, 4, 4, 1, 1, 4, 1, 1};
        Assertions.assertThrows(NullPointerException.class, () -> isArrOfThisNumbers(arr, null));
    }
}
