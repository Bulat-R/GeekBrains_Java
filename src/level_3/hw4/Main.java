package level_3.hw4;

public class Main {

    private String currentSymbol = "C";

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main::printA).start();
        new Thread(main::printB).start();
        new Thread(main::printC).start();
    }

    private synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            while (!currentSymbol.equals("C")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            currentSymbol = "A";
            notifyAll();
        }
    }

    private synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            while (!currentSymbol.equals("A")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            currentSymbol = "B";
            notifyAll();
        }
    }

    private synchronized void printC() {
        for (int i = 0; i < 5; i++) {
            while (!currentSymbol.equals("B")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            currentSymbol = "C";
            notifyAll();
        }
    }
}
