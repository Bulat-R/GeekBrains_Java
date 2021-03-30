package level_2.obstacle_course;

import java.util.Random;

public class Treadmill implements Obstacle {
    private final int distance;
    private final String name;

    public int getDistance() {
        return distance;
    }

    public Treadmill() {
        distance = new Random().nextInt(300) + 100;
        name = "дорожка длинной " + distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
