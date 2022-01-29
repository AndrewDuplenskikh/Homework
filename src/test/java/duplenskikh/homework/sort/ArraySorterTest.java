package duplenskikh.homework.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class ArraySorterTest {
    private ArraySorter filledArraySorter() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (new Random().nextInt(100));
        }
        ArraySorter arraySorter = new ArraySorter(array);
        return arraySorter;
    }

    private void eachPreviousElementShouldBeLessThanNextElement(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assertThat(array[i] <= array[i + 1]).isEqualTo(true);
        }
    }

    @Test
    void bubbleSortingShouldSortArrayIntoAscendingOrder() {
        ArraySorter arraySorter = filledArraySorter();
        int[] sortedArray = arraySorter.bubbleSort();
        eachPreviousElementShouldBeLessThanNextElement(sortedArray);
    }

    @Test
    void insertSortingShouldSortArrayIntoAscendingOrder() {
        ArraySorter arraySorter = filledArraySorter();
        int[] sortedArray = arraySorter.insertSort();
        eachPreviousElementShouldBeLessThanNextElement(sortedArray);
    }

    @Test
    void selectSortingShouldSortArrayIntoAscendingOrder() {
        ArraySorter arraySorter = filledArraySorter();
        int[] sortedArray = arraySorter.selectSort();
        eachPreviousElementShouldBeLessThanNextElement(sortedArray);
    }
}