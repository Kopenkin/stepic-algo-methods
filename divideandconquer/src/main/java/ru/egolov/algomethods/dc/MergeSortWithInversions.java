package ru.egolov.algomethods.dc;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortWithInversions {

    private long inversionSwaps;

    public long[] mergeSort(long[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private long[] mergeSort(long[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return merge(mergeSort(arr, l, m), mergeSort(arr, m + 1, r));
        }
        return new long[] {arr[l]};
    }

    private long[] merge(long[] arr1, long[] arr2) {
        long[] arr = new long[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; ++k) {
            if (i == arr1.length) {
                arr[k] = arr2[j++];
            } else if (j == arr2.length) {
                arr[k] = arr1[i++];
            } else if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i++];
            } else {
                arr[k] = arr2[j++];
                inversionSwaps += arr1.length - i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        MergeSortWithInversions sorting = new MergeSortWithInversions();
        sorting.mergeSort(arr);
        System.out.println(sorting.inversionSwaps);
    }
}
