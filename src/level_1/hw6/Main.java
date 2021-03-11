package level_1.hw6;

public class Main {
    public static void main(String[] args) {
        Cat murzik = new Cat("Murzik");
        Cat pushok = new Cat("Pushok");

        Dog barbos = new Dog("Barbos");

        murzik.run(120);
        murzik.swim(30);

        pushok.run(300);

        barbos.run(320);
        barbos.swim(8);

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCount());
        System.out.println(Dog.getCount());
    }
}
