package duplenskikh.homework.custom_linked_list;

import java.util.*;

public class CustomLinkedList<E> implements CustomList<E>, Deque<E> {
    private CustomLink<E> first;
    private CustomLink<E> last;

    private class CustomLink<E> {
        CustomLink<E> next;
        CustomLink<E> previous;
        E data;

        public CustomLink(E data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }

    public CustomLinkedList() {
        first = null;
        last = null;
    }

    public CustomLinkedList(E[] array) {
        first = null;
        last = null;
        for (int i = 0; i < array.length; i++) {
            addLast(array[i]);
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void addFirst(E e) {
        CustomLink<E> element = new CustomLink<E>(e);
        if (isEmpty()) {
            last = element;
        } else {
            first.previous = element;
        }
        element.next = first;
        first = element;
    }

    @Override
    public void addLast(E e) {
        CustomLink<E> element = new CustomLink<E>(e);
        if (isEmpty()) {
            first = element;
        } else {
            element.previous = last;
            last.next = element;
        }
        last = element;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        E temporary = first.data;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temporary;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        E temporary = last.data;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temporary;
    }

    @Override
    public boolean addAfter(E key, E element) {
        CustomLink<E> current = element(key);
        CustomLink<E> newElement = new CustomLink<E>(element);
        if (current.equals(last)) {
            last = newElement;
        } else {
            newElement.next = current.next;
            current.next.previous = newElement;
        }
        newElement.previous = current;
        current.next = newElement;
        return true;
    }

    @Override
    public E removeKey(E key) {
        CustomLink<E> current = element(key);
        if (current.equals(first)) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current.equals(last)) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current.data;
    }

    @Override
    public E find(E key) {
        CustomLink<E> current = element(key);
        return current.data;
    }

    private CustomLink<E> element(E key) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        CustomLink<E> current = first;
        while (!current.data.equals(key)) {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException("Element not found");
            }
        }
        return current;
    }

    // region заглушки для методов
    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
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
    // endregion
}
