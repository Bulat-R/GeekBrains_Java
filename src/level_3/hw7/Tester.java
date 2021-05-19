package level_3.hw7;

import level_3.hw7.annotations.AfterSuite;
import level_3.hw7.annotations.BeforeSuite;
import level_3.hw7.annotations.Test;

import java.lang.reflect.Method;
import java.util.PriorityQueue;

public class Tester {

    public static void start(String className) throws ReflectiveOperationException {
        start(Class.forName(className));
    }

    public static <T> void start(Class<T> testClass) throws ReflectiveOperationException {
        invokeMethods(testClass);
    }

    private static <T> void invokeMethods(Class<T> testClass) throws ReflectiveOperationException {
        Method beforeSuite = null;
        Method afterSuite = null;
        PriorityQueue<Method> testQueue = new PriorityQueue<>((o1, o2) -> o2.getAnnotation(Test.class).value().getPriority() - o1.getAnnotation(Test.class).value().getPriority());

        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                testQueue.add(method);
            }
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuite == null) {
                    beforeSuite = method;
                } else {
                    throw new RuntimeException();
                }
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterSuite == null) {
                    afterSuite = method;
                } else {
                    throw new RuntimeException();
                }
            }
        }

        T object = testClass.getConstructor().newInstance();
        if (beforeSuite != null) {
            beforeSuite.invoke(object);
        }
        while (!testQueue.isEmpty()) {
            testQueue.poll().invoke(object);
        }
        if (afterSuite != null) {
            afterSuite.invoke(object);
        }
    }
}
