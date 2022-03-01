package duplenskikh.homework.custom_hash_table;

public interface HashTable<E> {

    /**
     * Проверяет, пуста ли хэш-таблица
     *
     * @return true если хэш-таблица пуста
     */
    boolean isEmpty();

    /**
     * Вставляет в хеш-таблицу элемент. Для нахождения ячейки массива
     * хеш-таблицы использовать метод hashFunction
     *
     * @return true в случае успешной вставки
     * @param e элемент для вставки
     */
    boolean add(E e);

    /**
     * Находит и возвращает элемент в хэш-таблице
     *
     * @return элемент хэш-таблицы
     */
    E find(E e);

    /**
     * Удаляет и возвращает элемент хэш-таблицы
     *
     * @param e удаляемый элемент
     * @return элемент хэш-таблицы
     */
    E remove(E e);
}
