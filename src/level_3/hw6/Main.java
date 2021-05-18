package level_3.hw6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {

    public static int[] getSubArrayAfterLastNumber(int[] arr, int number) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == number) {
                int[] resultArr = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, resultArr, 0, resultArr.length);
                return resultArr;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isArrOfThisNumbers(int[] arr, int... numbers) {
        if (arr.length == 0 || numbers.length == 0) {
            return false;
        }
        return Arrays.stream(numbers)
                .distinct()
                .boxed()
                .collect(Collectors.toCollection(HashSet::new))
                .equals(
                        Arrays.stream(arr)
                                .distinct()
                                .boxed()
                                .collect(Collectors.toCollection(HashSet::new))
                );
    }
}
