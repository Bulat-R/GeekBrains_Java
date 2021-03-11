package level_1.hw6;

public class Dog extends Animal{

    private static int count;
    private static final int RUN_DISTANCE = 500;
    private static final int SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_DISTANCE && distance > 0) {
            System.out.println(this.getName() + " пробежал " + distance + " метров");
        } else {
            System.out.println("Что-то пошло не так. " + this.getName() + " отказывается это делать.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= SWIM_DISTANCE && distance > 0) {
            System.out.println(this.getName() + " проплыл " + distance + " метров");
        } else {
            System.out.println("Что-то пошло не так. " + this.getName() + " отказывается это делать.");
        }
    }

    public static int getCount(){
        return count;
    }
}
