package level_3.hw7;

import level_3.hw7.annotations.AfterSuite;
import level_3.hw7.annotations.BeforeSuite;
import level_3.hw7.annotations.Test;
import level_3.hw7.annotations.TestPriority;

public class SomeTestClass {

    @BeforeSuite()
    void before() {
        System.out.println("before");
    }

    @AfterSuite
    void after() {
        System.out.println("after");
    }

    @Test(TestPriority.TEN)
    void test10() {
        System.out.println("test 10");
    }

    @Test(TestPriority.ONE)
    void test1() {
        System.out.println("test 1");
    }

    @Test(TestPriority.SIX)
    void test6() {
        System.out.println("test 6");
    }

    @Test
    void testDefaultPriority() {
        System.out.println("test default priority (5)");
    }

    void notTest() {
        System.out.println("not test!");
    }
}
