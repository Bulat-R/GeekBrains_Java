package alg.hw5;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Backpack backpack = new Backpack(15);
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Item(random.nextInt(9) + 1, random.nextInt(9) + 1));
        }
        System.out.println("------------------ Backpack ------------------");
        System.out.println(items);
        System.out.println();
        System.out.println(fillBackpack(backpack, items));
        System.out.println();

        System.out.println("------------------ POW ------------------");
        System.out.println(pow(2, 8));
        System.out.println(pow(1, 999999999));
        System.out.println(pow(0, 5555555));
        System.out.println(pow(2, -5));
        System.out.println(pow(-1, 3));
        System.out.println(pow(-2, 4));
        System.out.println(pow(-1, -88888));

    }

    private static Backpack fillBackpack(Backpack backpack, List<Item> items) {
        if (backpack.isFull() || items.isEmpty()) {
            return backpack;
        }
        items.sort((i1, i2) -> Double.compare(i2.getRatio(), i1.getRatio()));
        backpack.put(items.remove(0));
        return fillBackpack(backpack, items);
    }

    private static double pow (int x, int y) {
        if (x == 0 && y <= 0) {
            throw new ArithmeticException();
        }
        if (x == 0) {
            return 0;
        }
        if (y == 0 || x == 1) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        if (y > 0) {
            return x * pow(x, y - 1);
        }
        return 1.0 / x * pow(x, y + 1);
    }
}

