package level_1.hw5;

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Vasya", "worker", "vasya@company.com", "1111111111", 50_000, 25),
                new Person("Ivan", "worker", "ivan@company.com", "2222222222", 50_000, 25),
                new Person("Tatyana Petrovna", "glavbuh", "tanchik72@company.com", "3333333333", 100_000, 48),
                new Person("Anatoliy", "manager", "anatoliy@company.com", "4444444444", 70_000, 37),
                new Person("Evgeniy Sergeevich", "boss", "boss@company.com", "7777777777", 500_000, 52),
        };

        for (Person person : persons) {
            if (person.getAge() > 40) {
                System.out.println(person.toString());
            }
        }
    }
}
