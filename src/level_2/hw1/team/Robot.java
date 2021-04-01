package level_2.hw1.team;

import java.util.Random;

public class Robot implements Teammate {
    private final int jumpHeight;
    private final int runDistance;
    private final String name;
    private static int count = 0;

    public Robot() {
        name = "робот №" + ++count;
        Random random = new Random();
        jumpHeight = random.nextInt(10) + 1;
        runDistance = random.nextInt(1000) + 100;
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
