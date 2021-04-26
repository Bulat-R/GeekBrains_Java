package level_3.hw1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private final List<T> fruitBox;

    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public float getWeight() {
        return (float) fruitBox.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public void put(T fruit) {
        fruitBox.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return Float.compare(this.getWeight(), box.getWeight()) == 0;
    }

    public void transfer(Box<T> box) {
        fruitBox.forEach(box::put);
        fruitBox.clear();
    }
}
