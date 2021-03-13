package level_1.hw6;

public class Dog extends Animal{

    private static int count;
    private static final int MAX_RUN_DIST = 500;
    private static final int MAX_SWIM_DIST = 10;

    public Dog(String name) {
        super(name, MAX_RUN_DIST, MAX_SWIM_DIST);
        count++;
    }

    public static int getCount(){
        return count;
    }
}
