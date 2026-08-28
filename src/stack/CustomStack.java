package stack;

public class CustomStack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public CustomStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(T element) {
        if (size == elements.length) {
            grow();
        }

        elements[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        checkNotEmpty();

        size--;

        T element = (T) elements[size];
        elements[size] = null;

        if (size == 0 && elements.length > DEFAULT_CAPACITY) {
            elements = new Object[DEFAULT_CAPACITY];
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        checkNotEmpty();

        return (T) elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public int capacity() {
        return elements.length;
    }
}
