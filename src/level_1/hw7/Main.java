package level_1.hw7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("№" + (i + 1), new Random().nextInt(10) + 2);
        }

        Plate plate = new Plate(20);
        plate.setFood(20);

        for (Cat cat : cats) {
            plate.info();
            System.out.println("Кот " + cat.getName() + ": аппетит - " + cat.getAppetite());
            cat.eat(plate);
            System.out.println("");
        }
    }
}
