package duplenskikh.homework.custom_stack;

public class CustomStack<T> implements Stackable<T> {
    private int top;
    private T[] array;

    private static final int INITIAL_TOP_POSITION = -1;
    private static final int SIZE_CORRECTION = 1;
    private static final String EMPTY_ERROR_MESSAGE = "Stack is empty!";
    private static final String FULL_ERROR_MESSAGE = "Stack is full!";

    public CustomStack(int size) {
        array = (T[]) new Object[size];
        top = INITIAL_TOP_POSITION;
    }

    @Override
    public int size() {
        return top + SIZE_CORRECTION;
    }

    @Override
    public void push(T t) {
        if (isFull()) {
            throw new CapacityException(FULL_ERROR_MESSAGE);
        }
        array[++top] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new CapacityException(EMPTY_ERROR_MESSAGE);
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new CapacityException(EMPTY_ERROR_MESSAGE);
        }
        return array[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == array.length - SIZE_CORRECTION;
    }


}
