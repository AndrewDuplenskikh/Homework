package duplenskikh.homework.sort;

public interface SimpleSorting {
    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called bubble sorting.
     *
     * @return sorted array of integers.
     */
    int[] bubbleSort();

    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called insert sorting.
     *
     * @return sorted array of integers.
     */
    int[] insertSort();

    /**
     * Replaces each element of array into ascending order.
     * Method should be defined by using algorithm called select sorting.
     *
     * @return sorted array of integers.
     */
    int[] selectSort();
}
