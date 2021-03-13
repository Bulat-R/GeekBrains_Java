package level_1.hw6;

public abstract class Animal {

    private String name;
    private final int MAX_RUN_DIST;
    private final int MAX_SWIM_DIST;
    private static int count;

    public Animal(String name, int max_run_dist, int max_swim_dist) {
        this.name = name;
        MAX_RUN_DIST = max_run_dist;
        MAX_SWIM_DIST = max_swim_dist;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (distance <= MAX_RUN_DIST && distance > 0) {
            System.out.println(this.getName() + " пробежал " + distance + " метров");
        } else {
            System.out.println("Что-то пошло не так. " + this.getName() + " отказывается это делать.");
        }
    }

    public void swim(int distance) {
        if (distance <= MAX_SWIM_DIST && distance > 0) {
            System.out.println(this.getName() + " проплыл " + distance + " метров");
        } else {
            System.out.println("Что-то пошло не так. " + this.getName() + " отказывается это делать.");
        }
    }
}
