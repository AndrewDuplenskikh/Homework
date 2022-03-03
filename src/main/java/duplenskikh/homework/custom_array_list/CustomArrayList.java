package duplenskikh.homework.custom_array_list;

import java.util.*;

public class CustomArrayList<T> implements List<T> {
    private int size;
    private T[] array;
    private static final int DEFAULT_ARRAY_LENGTH = 10;

    public CustomArrayList() {
        this.array = (T[]) new Object[DEFAULT_ARRAY_LENGTH];
        this.size = 0;
    }

    public CustomArrayList(int length) {
        this.array = (T[]) new Object[length];
        this.size = 0;
    }

    public CustomArrayList(T[] array) {
        this.array = copyOf(array);
        this.size = array.length;
    }

    public CustomArrayList(CustomArrayList<T> arrayList) {
        this.array = copyOf(arrayList.array);
        this.size = arrayList.size;
    }

    private T[] copyOf(T[] arr) {
        return copyOf(arr, arr.length);
    }

    private T[] copyOf(T[] arr, int newLength) {
        if (arr.length > newLength) {
            throw new IllegalArgumentException("New array length cannot be more than present array length.");
        }
        T[] resultArray = (T[]) new Object[newLength];
        for (int i = 0; i < arr.length; i++) {
            resultArray[i] = arr[i];
        };
        return resultArray;
    }

    private T[] copyOfRange(T[] arr, int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex < 0 || toIndex > arr.length) {
            throw new IllegalArgumentException("Wrong arguments.");
        }
        T[] resultArray = (T[]) new Object[toIndex - fromIndex];
        int j = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            resultArray[j] = arr[i];
            j++;
        };
        return resultArray;
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
            array = copyOf(array, (int) ((array.length*1.5) + 1));
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
            array = copyOf(array, (int) ((array.length*1.5) + 1));
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
        T element = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public CustomArrayList<T> subList(int fromIndex, int toIndex) {
        T[] newArray = copyOfRange(array, fromIndex, toIndex);
        return new <T>CustomArrayList(newArray);
    }

    @Override
    public T get(int index) {
        return array[index];
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
