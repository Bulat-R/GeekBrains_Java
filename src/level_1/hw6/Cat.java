package level_1.hw6;

public class Cat extends Animal{

    private static int count;
    private static final int MAX_RUN_DIST = 200;
    private static final int MAX_SWIM_DIST = 0;

    public Cat(String name) {
        super(name, MAX_RUN_DIST, MAX_SWIM_DIST);
        count++;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать.");
    }

    public static int getCount(){
        return count;
    }
}
