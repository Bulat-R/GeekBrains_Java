/*
Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
"pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
 */

package level_1.hw3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
            "pumpkin", "potato"};
    private static final int MAX_WORD_LENGTH = 15;

    public static void main(String[] args) {
        int attempt = 0;
        char[] showLetter = new char[MAX_WORD_LENGTH];
        String userWord;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Угадайте загаданное слово");
        String word = words[new Random().nextInt(words.length)];

        while (true) {
            attempt++;
            System.out.printf("Попытка №%d --> ", attempt);
            userWord = scanner.nextLine().toLowerCase();
            if (userWord.equals(word)) {
                System.out.println("Вы угадали! Слово - " + word);
                break;
            }
            System.out.print("Угаданные буквы: ");
            for (int i = 0; i < showLetter.length; i++) {
                if (i < userWord.length() && i < word.length() && userWord.charAt(i) == word.charAt(i)) {
                    showLetter[i] = userWord.charAt(i);
                } else {
                    showLetter[i] = '#';
                }
                System.out.print(showLetter[i]);
            }
            System.out.println();
        }
        scanner.close();
    }
}

