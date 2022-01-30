package duplenskikh.homework.custom_queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CustomQueue<T> implements Queue<T> {
    private int front;
    private int rear;
    private int elementsCount;
    private T[] array;

    private static final int INITIAL_FRONT_POSITION = 0;
    private static final int INITIAL_REAR_POSITION = -1;
    private static final int INITIAL_LENGTH = 0;
    private static final String EMPTY_ERROR_MESSAGE = "Queue is empty!";
    private static final String FULL_ERROR_MESSAGE = "Queue is full!";

    public CustomQueue(int size) {
        array = (T[]) new Object[size];
        front = INITIAL_FRONT_POSITION;
        rear = INITIAL_REAR_POSITION;
        elementsCount = INITIAL_LENGTH;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private boolean isFull() {
        return elementsCount == array.length;
    }

    @Override
    public boolean add(T t) {
        if (isFull()) {
            throw new IllegalStateException(FULL_ERROR_MESSAGE);
        }
        if (rear == array.length - 1) {
            rear = -1;
        }
        array[++rear] = t;
        elementsCount++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_ERROR_MESSAGE);
        }
        T element = array[front++];
        if (front == array.length) {
            front = 0;
        }
        elementsCount--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_ERROR_MESSAGE);
        }
        return array[front];
    }

    //region заглушки для не реализованных методов

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    //endregion
}
