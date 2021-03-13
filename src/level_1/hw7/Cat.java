package level_1.hw7;

public class Cat {

    private String name;
    private int appetite;
    private boolean isCatFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isCatFull() {
        return isCatFull;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(this.appetite)) {
            this.isCatFull = true;
            System.out.println("Кот " + this.name + " поел и сыто заурчал");
        } else {
            System.out.println("Кот " + this.name + " остался голоден");
        }
    }
}
