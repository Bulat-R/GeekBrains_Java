/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
2. Создать переменные всех пройденных типов данных и инициализировать их значения.
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – аргументы этого метода,
   имеющие тип float.
4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
   если да – вернуть true, в противном случае – false.
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное
   ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное,
   и вернуть false если положительное.
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль
   сообщение «Привет, указанное_имя!».
8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является
   високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/

package level_1.hw1;

public class Homework1 {
    // Задание №1
    public static void main(String[] args) {

        // Задание №2
        byte b = 1;
        short s = 125;
        int i = 254238;
        long l = 12345678900000L;
        float f = 0.25f;
        double d = 125586.25658;
        char c = 'B';
        String str = "string";
        boolean bool = true;

        // Задание №3
        System.out.println(calcFloat(0.1f, 0.1f, 0.1f, 0.1f));

        // Задание №4
        System.out.println(isBetween10And20(10, 12));

        // Задание №5
        printPositiveOrNegative(-25);

        // Задание №6
        System.out.println(isNegative(-9));

        // Задание №7
        sayHello("Ivan");

        // Задание №8
        isYearLeap(400);
    }

    private static float calcFloat(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean isBetween10And20(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    private static void printPositiveOrNegative(int a) {
        System.out.println(a < 0 ? "отрицательное" : "положительное");
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void sayHello (String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void isYearLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " год - високосный");
        } else {
            System.out.println(year +" год - не високосный");
        }
    }
}