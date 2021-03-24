package level_1.hw8.calc_with_gui;

public class CalculatorFactory {

    public static CalculatorService getCalculatorService() {
        return new CalculatorServiceImpl();
    }

}
