package level_1.hw8.calk_with_gui;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorServiceImpl implements CalculatorService {
    private String firstOperand;
    private String secondOperand;
    private String operation;
    private StringBuilder sb = new StringBuilder("");

    public String analyzeAndReturnOutput(String symb) {

        switch (symb) {
            case "0" :
                if (sb.toString().equals("0")) {
                    break;
                }
            case "1" :
            case "2" :
            case "3" :
            case "4" :
            case "5" :
            case "6" :
            case "7" :
            case "8" :
            case "9" :
                sb.append(symb);
                writeOperand(sb.toString());
                return sb.toString();
            case "." :
                if (!sb.toString().contains(".")) {
                    if (sb.length() == 0) {
                        sb.append("0").append(symb);
                    } else sb.append(symb);
                    writeOperand(sb.toString());
                    return sb.toString();
                }
                break;
            case "C" :
                sb = new StringBuilder("");
                firstOperand = null;
                secondOperand = null;
                operation = null;
                return "0";
            case "+/-" :
                if (sb.length() > 0) {
                    if (sb.charAt(0) != '-') {
                        sb.insert(0, '-');
                    } else {
                        sb.deleteCharAt(0);
                    }
                    writeOperand(sb.toString());
                    return sb.toString();
                } else if (firstOperand != null && operation == null) {
                    sb = new StringBuilder(firstOperand);
                    if (sb.charAt(0) != '-') {
                        sb.insert(0, '-');
                    } else {
                        sb.deleteCharAt(0);
                    }
                    firstOperand = null;
                    writeOperand(sb.toString());
                    return sb.toString();
                }
                break;
            case "<" :
                if (sb.toString().equals("0.") || sb.toString().equals("-0.") || (sb.toString().length() == 2 && sb.charAt(0) == '-')) {
                    sb = new StringBuilder("");
                    writeOperand(sb.toString());
                    return "0";
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                    writeOperand(sb.toString());
                } else if (sb.length() == 1) {
                    sb.deleteCharAt(0);
                    writeOperand(sb.toString());
                    return "0";
                } else break;
                writeOperand(sb.toString());
                return sb.toString();
            case "+" :
            case "-" :
            case "*" :
            case "/" :
                return calculate(firstOperand, secondOperand, symb);
            case "=" :
                sb = new StringBuilder("");
                if (this.operation != null) {
                    if (firstOperand != null) {
                        if (secondOperand != null) {
                            this.firstOperand = doOperation(firstOperand, secondOperand, this.operation);
                            this.secondOperand = null;
                            this.operation = null;
                            return this.firstOperand;

                        }
                    }
                }
                return null;
            case "%" :
                if (firstOperand != null && secondOperand != null) {
                    secondOperand = getPercent(firstOperand, secondOperand);
                    return secondOperand;
                }
                break;
        }
        return null;
    }

    private String calculate(String firstOperand, String secondOperand, String operation) {
        sb = new StringBuilder("");
        if (this.operation != null) {
            if (firstOperand != null) {
                if (secondOperand != null) {
                    this.firstOperand = doOperation(firstOperand, secondOperand, this.operation);
                    this.secondOperand = null;
                    this.operation = operation;
                    return this.firstOperand;

                } else {
                    this.operation = operation;
                }
            } else {
                this.firstOperand = "0";
                this.operation = operation;
            }
        } else {
            this.operation = operation;
        }
        return null;
    }
    private String doOperation(String firstOperand, String secondOperand, String operation) {
        switch (operation) {
            case "+" : return getSumm(firstOperand, secondOperand);
            case "-" : return getDiff(firstOperand, secondOperand);
            case "*" : return getMulti(firstOperand, secondOperand);
            case "/" : return getDiv(firstOperand, secondOperand);
        }
        return "unknown error";
    }

    private String getSumm(String firstOperand, String secondOperand) {
        BigDecimal first = new BigDecimal(firstOperand);
        BigDecimal second = new BigDecimal(secondOperand);
        return formatStr(first.add(second).toString());
    }

    private String getDiff(String firstOperand, String secondOperand) {
        BigDecimal first = new BigDecimal(firstOperand);
        BigDecimal second = new BigDecimal(secondOperand);
        return formatStr(first.subtract(second).toString());
    }

    private String getMulti(String firstOperand, String secondOperand) {
        BigDecimal first = new BigDecimal(firstOperand);
        BigDecimal second = new BigDecimal(secondOperand);
        return formatStr(first.multiply(second).toString());
    }

    private String getDiv(String firstOperand, String secondOperand) {
        BigDecimal first = new BigDecimal(firstOperand);
        BigDecimal second = new BigDecimal(secondOperand);
        if (second.compareTo(new BigDecimal("0")) == 0) {
            return "error - divide by zero";
        }
        try {
            return formatStr(first.divide(second).toString());
        } catch (ArithmeticException e) {
            return first.divide(second, 20, RoundingMode.CEILING).toString();
        }
    }

    private String getPercent (String firstOperand, String secondOperand) {
        BigDecimal first = new BigDecimal(firstOperand);
        BigDecimal second = new BigDecimal(secondOperand);
        return formatStr(first.multiply(second).divide(new BigDecimal("100")).toString());
    }

    private void writeOperand(String str) {
        if (str.equals("")) {
            str = null;
        }
        if (operation == null) {
            firstOperand = str;
        } else {
            secondOperand = str;
        }
    }

    private String formatStr(String str) {
        if (str.contains(".")) {
            if (str.charAt(str.length() - 1) == '0' || str.charAt(str.length() - 1) == '.') {
                str = str.substring(0, str.length() - 1);
                return formatStr(str);
            }
        }
        return str;
    }
}
