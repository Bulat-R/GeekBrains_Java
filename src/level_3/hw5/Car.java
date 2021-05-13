package level_3.hw5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static final AtomicInteger CARS_COUNT;
    static {
        CARS_COUNT = new AtomicInteger(0);
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch startCount;
    private CountDownLatch endCount;
    private CyclicBarrier barrier;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch startCount, CyclicBarrier barrier, CountDownLatch endCount) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT.incrementAndGet();
        this.name = "Участник #" + CARS_COUNT;
        this.startCount = startCount;
        this.barrier = barrier;
        this.endCount = endCount;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            startCount.countDown();
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        endCount.countDown();
        if (checkWin()) {
            System.out.println(this.name + " WIN");
        }
    }

    private boolean checkWin(){
        synchronized (CARS_COUNT) {
            return endCount.getCount() + 1 == CARS_COUNT.get();
        }
    }
}
