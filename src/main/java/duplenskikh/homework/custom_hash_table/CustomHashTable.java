package duplenskikh.homework.custom_hash_table;

import duplenskikh.homework.custom_linked_list.CustomLinkedList;

public class CustomHashTable<E> implements HashTable<E> {
    private final CustomLinkedList<E>[] storage;
    private int elementCount;

    public CustomHashTable(int size) {
        storage = new CustomLinkedList[size];
        elementCount = 0;
        for (int i = 0; i < size; i++) {
            storage[i] = new CustomLinkedList<>();
        }
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public boolean add(E element) {
        int hash = element.hashCode();
        int key = hashFunction(hash);
        storage[key].addFirst(element);
        elementCount++;
        return true;
    }

    @Override
    public E find(E element) {
        int hash = element.hashCode();
        int key = hashFunction(hash);
        return storage[key].find(element);
    }

    @Override
    public E remove(E element) {
        int hash = element.hashCode();
        int key = hashFunction(hash);
        E removedElement = storage[key].removeKey(element);
        elementCount--;
        return removedElement;
    }

    private int hashFunction(int hash) {
        int absoluteValue = Math.abs(hash);
        return absoluteValue % storage.length;
    }
}
