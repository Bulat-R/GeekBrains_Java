package level_3.hw7.annotations;

public enum TestPriority {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);
    private final int priority;

    TestPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
