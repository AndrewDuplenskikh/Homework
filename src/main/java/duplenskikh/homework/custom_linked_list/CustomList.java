package duplenskikh.homework.custom_linked_list;

import java.util.NoSuchElementException;

public interface CustomList<E> {
    /**
     * Добавляет новый элемент в список после элемента, указанного в
     * в качестве ключа.
     *
     * @param key элемент, после которого необходимо вставить
     * @param element элемент, который вставляем в список
     * @return true при успешном добавлении элемента в список
     */
    boolean addAfter(E key, E element);

    /**
     * Удаляет и возвращает указанный элемент из списка.
     *
     * @param key удаляемый из списка элемент
     * @return элемент по заданному ключу
     */
    E removeKey(E key);

    /**
     * Находит и возвращает указанный элемент, если он принадлежит
     * списку
     *
     * @param key искомый элемент
     * @return этот искомый элемент
     */
    E find(E key);
}
