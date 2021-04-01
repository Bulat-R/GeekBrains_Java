package level_2.hw2;

public class Main {
    public static void main(String[] args) {

        String[][] array1 = {   {"1", "2", "3", "4"},
                                {"5", "6", "7", "8"},
                                {"9", "0", "1", "2"},
                                {"3", "4", "5", "6"}   };

        String[][] array2 = {   {"1", "2", "3", "4"},
                                {"5", "6", "s", "8"},
                                {"9", "0", "1", "2"},
                                {"3", "4", "5", "6"}   };

        String[][] array3 = {   {"1", "2", "3", "4"},
                                {"5", "6", "7", "8"},
                                {"9", "0", "1", "2"}   };

        try {
            System.out.println(sumStringArray(array1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumStringArray(array2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(sumStringArray(array3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sumStringArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }
        for (String[] strings : array) {
            for (String string : strings) {
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return sum;
    }

}

