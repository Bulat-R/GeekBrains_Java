package alg.hw4;

public class MyStack<E> {
    private final MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E element) {
        list.insertFirst(element);
    }

    public E pop() {
        return list.removeLast();
    }

    public E peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
