package duplenskikh.homework.sort;

public interface SimpleSortings {
    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called bubble sorting.
     *
     * @return sorted array of integers.
     */
    public int[] bubbleSort();

    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called insert sorting.
     *
     * @return sorted array of integers.
     */
    public int[] insertSort();

    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called select sorting.
     *
     * @return sorted array of integers.
     */
    public int[] selectSort();
}
