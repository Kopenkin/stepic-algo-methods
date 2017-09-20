package ru.egolov.algomethods.dc;

/**
 *
 */
public class QuickSort {

    public void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m + 1, r);
    }

    private int partition(int arr[], int l, int r) {
        int pivot = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; ++i) {
            if (arr[i] <= pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[l] = arr[j];
        arr[j] = pivot;
        return j;
    }
}
