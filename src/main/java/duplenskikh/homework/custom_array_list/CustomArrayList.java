package duplenskikh.homework.custom_array_list;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class CustomArrayList<T> implements List<T> {
    private int size;
    private Object[] array;

    public CustomArrayList() {
        this.array = new Object[10];
        this.size = 0;
    }

    public CustomArrayList(int length) {
        this.array = new Object[length];
        this.size = 0;
    }

    public CustomArrayList(Object[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.size = array.length;
    }

    public CustomArrayList(CustomArrayList arrayList) {
        array = Arrays.copyOf(arrayList.array, arrayList.size, arrayList.array.getClass());
        this.size = arrayList.size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) ((array.length*1.5) + 1));
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Wrong argument: index");
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) ((array.length*1.5) + 1));
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Wrong argument: index");
        }
        T element = (T) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public CustomArrayList<T> subList(int fromIndex, int toIndex) {
        Object[] newArray = Arrays.copyOfRange(array, fromIndex, toIndex);
        return new CustomArrayList<T>(newArray);
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    //region another methods to implement

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
    //endregion
}
