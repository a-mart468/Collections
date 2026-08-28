package stack;


public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    @Override
    public void push(T element) {
        top = new Node<>(element,top);
        size++;

    }

    @Override
    public T pop() {
        checkNotEmpty();

        Node<T> removeNode = top;
        top = top.next;
        size--;

        return removeNode.element;
    }

    @Override
    public T peek() {
        checkNotEmpty();
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkNotEmpty() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
    }

    private static class Node<T> {
        private final T element;
        private final Node<T> next;

        private Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}
