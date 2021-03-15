package level_1.hw7;

public class Plate {

    private int food;
    private int size;

    public Plate(int size) {
        this.size = size;
    }

    public void setFood(int food) {
        if (food > 0 && food <= size){
            this.food = food;
        } else if (food > size) {
            System.out.println("Количество еды превышает размер тарелки");
        } else {
            System.out.println("Некорректное значение");
        }
    }

    public boolean decreaseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
            return true;
        } else {
            return false;
        }
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }
}
