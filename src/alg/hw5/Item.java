package alg.hw5;

public class Item {
    private final double weight;
    private final double price;
    private final double ratio;

    public Item(double weight, double price) {
        this.weight = weight;
        this.price = price;
        this.ratio = price / weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
