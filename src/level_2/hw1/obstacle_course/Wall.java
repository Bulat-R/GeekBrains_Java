package level_2.hw1.obstacle_course;

import java.util.Random;

public class Wall implements Obstacle {
    private final int height;
    private final String name;

    public int getHeight() {
        return height;
    }

    public Wall() {
        height = new Random().nextInt(3) + 1;
        name = "стена высотой " + height;
    }

    @Override
    public String toString() {
        return name;
    }
}
