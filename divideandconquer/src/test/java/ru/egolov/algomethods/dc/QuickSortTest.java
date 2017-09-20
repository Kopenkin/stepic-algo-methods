package ru.egolov.algomethods.dc;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    private QuickSort qs = new QuickSort();

    @Test
    public void quickSortTest() {
        int[] arr = {4, 3, 2, 1};
        qs.quickSort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 4}, arr);

        int[] arr1 = {1};
        qs.quickSort(arr1);
        assertArrayEquals(new int[] {1}, arr1);

        int[] arr2 = {1, 2};
        qs.quickSort(arr2);
        assertArrayEquals(new int[] {1, 2}, arr2);
    }
}
