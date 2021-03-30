package level_2.team;

import java.util.Random;

public class Human implements Teammate {
    private final int jumpHeight;
    private final int runDistance;
    private final String name;
    private static int count = 0;

    public Human() {
        name = "человек №" + ++count;
        Random random = new Random();
        jumpHeight = random.nextInt(3) + 1;
        runDistance = random.nextInt(300) + 100;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean canJump(int height) {
        String result = jumpHeight >= height ? "преодолел препятствие" : "не справился и выбывает";
        System.out.println(name + " " + result);
        return jumpHeight >= height;
    }

    @Override
    public boolean canRun(int distance) {
        String result = runDistance >= distance ? "преодолел препятствие" : "не справился и выбывает";
        System.out.println(name + " " + result);
        return runDistance >= distance;
    }
}
