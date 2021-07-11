package alg.hw6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int balanced = 0;
        int notBalanced = 0;
        for (int i = 0; i < 1000_000; i++) {
            MyTreeMap<Integer, String> map = getRandomMap(6, -100, 100);
            if (map.isBalanced()) {
                balanced++;
            } else {
                notBalanced++;
            }
        }
        System.out.println("balanced: " + balanced + ", not balanced: " + notBalanced);
        int p = (balanced / (balanced + notBalanced)) * 100;
        System.out.println("balanced: " + p + "%");
    }

    public static MyTreeMap<Integer, String> getRandomMap(int depth, int minKey, int maxKey) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        Random random = new Random();
        while (map.getTreeDepth() < depth) {
            int key = random.nextInt(maxKey - minKey + 1) + minKey;
            map.put(key, "valueOf" + key);
        }
        return map;
    }
}
