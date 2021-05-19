package level_3.hw7;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {
        Tester.start(SomeTestClass.class);
        System.out.println("==================================");
        Tester.start("level_3.hw7.SomeTestClass");
    }
}
