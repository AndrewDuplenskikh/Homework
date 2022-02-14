package duplenskikh.homework.custom_binary_tree;

/**
 * Двоичные деревья
 */
public interface BinaryTree<E> {
    /**
     * Проверяет, пусто ли двоичное дерево.
     *
     * @return true если дерево пустое.
     */
    boolean isEmpty();

    /**
     * Добавляет элемент в двоичное дерево.
     *
     * @param key ключ, по которому обеспечивается доступ к элементу
     * @param e добавляемый в дерево элемент
     */
    void addElement(int key, E e);

    /**
     * Находит элемент по указанному ключу и возвращает
     * значение, соответствующее этому ключу.
     *
     * @param key ключ, по которому ведется поиск
     * @return искомый элемент
     */
    E findElement(int key);

    /**
     * Удаляет элемент по указанному ключу из дерева, сохраняя
     * порядок двоичного дерева, и возвращает значение,
     * соответствующее этому ключу
     *
     * @param key ключ элемента, который требуется удалить
     * @return удаляемый элемент
     */
    E removeElement(int key);
}
