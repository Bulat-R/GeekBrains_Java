package alg.hw3;

public class Main {

    public static void main(String[] args) {
//        System.out.println(reverse("abcdefghigk"));

        MyDeque<Integer> d = new MyDeque<>(6);
        System.out.println(d);
        d.insertRight(2);
        System.out.println(d);
        d.insertLeft(1);
        System.out.println(d);
        d.insertRight(3);

        d.insertLeft(0);
        d.insertRight(4);
        d.insertRight(5);
        System.out.println(d);
        d.insertRight(6);
        System.out.println(d);
        System.out.println(d.removeLeft());
        d.removeRight();
        d.removeRight();
        d.removeRight();
        d.removeRight();
        d.removeRight();
        d.removeRight();
        System.out.println(d);
    }

    public static String reverse(String string) {
        MyStack<Character> stack = new MyStack<>(string.length());
        for (Character ch : string.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
