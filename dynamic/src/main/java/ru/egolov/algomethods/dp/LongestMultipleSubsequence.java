package ru.egolov.algomethods.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LongestMultipleSubsequence {

    public int lms(long[] arr) {
        int max = 1;
        int[] d = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            d[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0 && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    max = Math.max(max, d[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        long[] sequence = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int maxSubSequence = new LongestMultipleSubsequence().lms(sequence);
        System.out.println(maxSubSequence);
    }
}
