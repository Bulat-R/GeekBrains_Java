package level_1.hw4;

import java.util.*;

public class TicTacToe {
    private static final int MAP_HEIGHT = 5;
    private static final int MAP_WIDTH = 5;
    private static final int DOT_TO_WIN = 4;
    private static char[][] map;

    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final char DOT_EMPTY = '*';

    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();

        do {
            printMap();
            humanTurn();
            aiTurn();
        } while (!checkWinner());

    }

    //Инициализация карты
    private static void initMap() {
        map = new char[MAP_HEIGHT][MAP_WIDTH];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //Печать карты
    private static void printMap() {
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    //Ход игрока
    private static void humanTurn() {
        int x = -1;
        int y = -1;
        do {
            System.out.println("Ваш ход. Введите координаты X Y через пробел");
            try {
                x = Integer.parseInt(scanner.next()) - 1;
                y = Integer.parseInt(scanner.next()) - 1;

                if (isCellNotValid(x, y)) {
                    System.out.println("Некорректный ввод");
                }

            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        } while (isCellNotValid(x, y));
        map[y][x] = DOT_X;
        printMap();
    }

    //Проверка валидности хода
    private static boolean isCellNotValid(int x, int y) {
        if (x < 0 || x >= MAP_WIDTH || y < 0 || y >= MAP_HEIGHT) {
            return true;
        }
        return map[y][x] != DOT_EMPTY;
    }

    //Проерка победителя
    private static boolean checkWinner() {

        //проверяем горизонтали
        for (int i = 0; i < map.length; i++) {
            if (isLineWin(map[i], DOT_X)) {
                System.out.println("Вы выиграли!");
                return true;
            }
            if (isLineWin(map[i], DOT_0)) {
                System.out.println("Вы проиграли!");
                return true;
            }
        }

        //проверяем вертикали
        for (int i = 0; i < map.length; i++) {
            char[] tmp = new char[map.length];
            for (int j = 0; j < map.length; j++) {
                tmp[j] = map[j][i];
            }
            if (isLineWin(tmp, DOT_X)) {
                System.out.println("Вы выиграли!");
                return true;
            }
            if (isLineWin(tmp, DOT_0)) {
                System.out.println("Вы проиграли!");
                return true;
            }
        }

        //переменнаяя для дополнительных диагоналей
        int moreDiags = map.length - DOT_TO_WIN;

        //Главная диагональ и ее дополнения
        for (int i = - moreDiags; i <= moreDiags; i++) {
            char[] tmp = new char[map.length - Math.abs(i)];
            for (int j = 0; j < tmp.length; j++) {
                if (i < 0) {
                    tmp[j] = map[j][j + Math.abs(i)];
                } else {
                    tmp[j] = map[j + Math.abs(i)][j];
                }
            }
            if (isLineWin(tmp, DOT_X)) {
                System.out.println("Вы выиграли!");
                return true;
            }
            if (isLineWin(tmp, DOT_0)) {
                System.out.println("Вы проиграли!");
                return true;
            }

        }

        //Побочная диагональ и ее дополнения
        for (int i = - moreDiags; i <= moreDiags; i++) {
            char[] tmp = new char[map.length - Math.abs(i)];
            for (int j = tmp.length - 1, k = 0; j >= 0; j--, k++) {
                if (i < 0) {
                    tmp[j] = map[j][k];
                } else {
                    tmp[j] = map[k + Math.abs(i)][j + Math.abs(i)];
                }
            }
            if (isLineWin(tmp, DOT_X)) {
                System.out.println("Вы выиграли!");
                return true;
            }
            if (isLineWin(tmp, DOT_0)) {
                System.out.println("Вы проиграли!");
                return true;
            }
        }
        return false;
    }

    //Ход ИИ
    private static void aiTurn() {

        int y = -1;
        int x = -1;

        if (checkAllLines(map)[0] != -1) {
            y = checkAllLines(map)[0];
            x = checkAllLines(map)[1];

            map[y][x] = DOT_0;
            System.out.println("ИИ сходил в ячейку " + (x + 1) + " " + (y + 1));

        } else {
            do {
                y = random.nextInt(map.length);
                x = random.nextInt(map.length);
            } while (isCellNotValid(x, y));
            map[y][x] = DOT_0;
            System.out.println("ИИ сходил в ячейку " + (x + 1) + " " + (y + 1));
        }
    }

    //Метод проверяет все линии из игровой карты, на которых можно построить выигрышную последовательность,
    //и возвращает координаты для блокировки или { -1, -1 }
    private static int[] checkAllLines(char[][] map) {
        int[] coord = { -1, -1 };

        //Проверяем все диагонали в отдельном методе
        coord = checkDiags(map, map.length - DOT_TO_WIN);
        System.out.println(coord[0]);
        if (coord[0] != -1) {
            return coord;
        }

        //Все горизонтали
        for (int i = 0; i < map.length; i++) {
            if (twoWayCheck(map[i]) != -1) {
                coord[0] = i;
                coord[1] = twoWayCheck(map[i]);
                return coord;
            }
        }

        //Все вертикали
        for (int i = 0; i < map.length; i++) {
            char[] tmp = new char[map.length];
            for (int j = 0; j < map.length; j++) {
                tmp[j] = map[j][i];
            }
            if (twoWayCheck(tmp) != -1 ) {
                coord[0] = twoWayCheck(tmp);
                coord[1] = i;
                return coord;
            }
        }

        return coord;
    }

    //Метод получает из игровой карты все диагонали и проверяет их.
    private static int[] checkDiags(char[][] map, int moreDiags) {
        int[] coord = { -1, -1 };

        //Главная диагональ и ее дополнения
        for (int i = - moreDiags; i <= moreDiags; i++) {
            char[] tmp = new char[map.length - Math.abs(i)];
            for (int j = 0; j < tmp.length; j++) {
                if (i < 0) {
                    tmp[j] = map[j][j + Math.abs(i)];
                } else {
                    tmp[j] = map[j + Math.abs(i)][j];
                }
            }
            if (twoWayCheck(tmp) != -1 ) {
                if (i < 0) {
                    coord[0] = twoWayCheck(tmp);
                    coord[1] = Math.abs(i) + twoWayCheck(tmp);
                } else {
                    coord[1] = twoWayCheck(tmp);
                    coord[0] = Math.abs(i) + twoWayCheck(tmp);
                }
                return coord;
            }
        }

        //Побочная диагональ и ее дополнения
        for (int i = - moreDiags; i <= moreDiags; i++) {
            char[] tmp = new char[map.length - Math.abs(i)];
            for (int j = tmp.length - 1, k = 0; j >= 0; j--, k++) {
                if (i < 0) {
                    tmp[j] = map[j][k];
                } else {
                    tmp[j] = map[k + Math.abs(i)][j + Math.abs(i)];
                }
            }

            if (twoWayCheck(tmp) != -1) {

                if (i < 0) {
                    coord[0] = twoWayCheck(tmp);
                    coord[1] = tmp.length - 1 - twoWayCheck(tmp);
                } else {
                    coord[0] = tmp.length - 1 - twoWayCheck(tmp);
                    coord[1] = twoWayCheck(tmp);
                }
                return coord;
            }
        }

        return coord;
    }

    //Метод проверет одну линию в обе стороны на последовательность крестиков
    private static int twoWayCheck(char[] line) {
        if (oneWayCheck(line) != -1) {
            return oneWayCheck(line);
        }

        char[] reverseLine = new char[line.length];
        for (int i = 0; i < line.length; i++) {
            reverseLine[i] = line[line.length - 1 - i];
        }

        if (oneWayCheck(line) != -1) {
            return line.length -1 - oneWayCheck(line);
        }

        return -1;
    }

    //Метод проверкяет одну линию на последовательность крестиков
    //метод правильно не работает :(
    private static int oneWayCheck(char[] line) {
        int alarm;                      //Заводим переменную - опасное количество крестиков
        if (DOT_TO_WIN < line.length) {
            alarm = DOT_TO_WIN - 1;
        } else {
            alarm = DOT_TO_WIN;
        }

        int countX = 0;                // Заводим переменную - счетчик крестиков
        int countEmpty = 0;            //Заводим переменную - счетчик пустых ячеек

        for (int i = 0; i < line.length - 1; i++) {
            if (line[i] == DOT_EMPTY) {                                 //Если в ячейке пусто
                countEmpty++;                                               //считаем

                if(line[i + 1] == DOT_X && countEmpty == 1){     //А в следующией ячейке крестик (для случаев типа * X X * X)
                    countX++;                                           //это опасно
                }

                if (countX >= alarm){                                       //Если опасное кол-во
                    return i;                                                   //возвращаем эту пустую ячейку для хода
                }

            } else if (line[i] == DOT_X) {                              //Если в ячейке крестик
                countX++;                                                   //считаем

                if (countX >= alarm && line[i + 1] == DOT_EMPTY) {          //Если крестиков опасное кол-во и есть пустая
                    return i + 1;                                               //возвращаем ячейку для хода
                }

            } else if (line[i] == DOT_0 || countEmpty > 1){             //Если нолик или 2 пустые подряд
                countX = 0;                                                 //сбрасываем счетчики
                countEmpty = 0;
            }
        }

        return -1;      //Если ни одно условие не сработало - возвращаем -1
    }

    //Проверка линии на выигрышную последовательность
    private static boolean isLineWin(char[] line, char ch) {
        int count = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == ch) {
                count++;
                if(count == DOT_TO_WIN) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
