package ru.egolov.algomethods.dc;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class BinarySearch {

    private final long[] array;

    public BinarySearch(long[] array) {
        this.array = array;
    }

    public int find(long val) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
//            actually, it's not needed since overflow is not possible here
//            so simply (l + r) / 2 would be enough
            int m = l + (r - l) / 2;
            if (array[m] == val) {
//                to adjust indexes starting from 1
                return m + 1;
            } else if (array[m] > val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        long[] longs = Arrays.stream(firstLine).mapToLong(Long::parseLong).toArray();
        BinarySearch bs = new BinarySearch(Arrays.copyOfRange(longs, 1, longs.length));

        String[] secondLine = scanner.nextLine().split(" ");

        long[] toFind = Arrays.stream(secondLine).mapToLong(Long::parseLong).toArray();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= toFind[0]; ++i) {
            long k = toFind[i];
            result.append(bs.find(k));
            if (i != toFind[0]) {
                result.append(" ");
            }
        }
        System.out.println(result.toString());
    }
}
