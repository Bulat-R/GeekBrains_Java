/*
Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/

package level_1.hw3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int FROM = 0;
    private static final int TO = 9;
    private static final int ATTEMPTS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;
        int userNumber;
        int attemptsLeft;
        boolean playAgain;

        do {
            attemptsLeft = ATTEMPTS;

            number = new Random().nextInt(TO - FROM + 1) + FROM;

            System.out.printf("Угадайте число от %d до %d. У вас %d попытка(ки).%n", FROM, TO, ATTEMPTS);

            while (attemptsLeft > 0) {
                System.out.printf("Попытка №%d. Введите число --> ",(ATTEMPTS - attemptsLeft + 1));
                userNumber = scanner.nextInt();
                attemptsLeft--;
                if (userNumber > TO || userNumber < FROM) {
                    System.out.println("Некорректный ввод");
                    attemptsLeft++;
                } else if (userNumber == number) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (attemptsLeft != 0){
                    System.out.print("Загаданное число " + (userNumber > number ? "меньше. " : "больше. "));
                    System.out.printf("Осталось %d попытка(ки).%n", attemptsLeft);
                } else {
                    System.out.printf("Вы проиграли! Загаданное число - %d%n", number);
                }
            }
            while (true) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    playAgain = true;
                    break;
                } else if (answer == 0){
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Некорректный ввод");
                }
            }
        } while (playAgain);

        scanner.close();
    }
}
