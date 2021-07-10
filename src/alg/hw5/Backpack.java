package alg.hw5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final List<Item> list;
    private final double fullCapacity;
    private double availableCapacity;

    public Backpack(double fullCapacity) {
        this.list = new ArrayList<>();
        this.fullCapacity = fullCapacity;
        this.availableCapacity = fullCapacity;
    }

    public Backpack put(Item item) {
        if (canPut(item)) {
            list.add(item);
            availableCapacity -= item.getWeight();
        }
        return this;
    }

    private boolean canPut(Item item) {
        return item.getWeight() <= availableCapacity;
    }

    public double getWeight() {
        return fullCapacity - availableCapacity;
    }

    public double getPrice() {
        int price = 0;
        for (Item item : list) {
            price += item.getPrice();
        }
        return price;
    }

    public boolean isFull() {
        return availableCapacity == 0;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "list=" + list +
                '}' + " weight = " + getWeight() + " price = " + getPrice();
    }
}
