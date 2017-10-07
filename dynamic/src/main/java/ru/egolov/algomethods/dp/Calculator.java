package ru.egolov.algomethods.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {

    public int[] findMinPath(int n) {
        int[] d = new int[n + 1];
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            d[i] = Integer.MAX_VALUE;
            nums[i] = Integer.MAX_VALUE;
        }
        d[n] = 0;
        for (int i = n; i > 1; --i) {
            if (d[i - 1] > d[i] + 1) {
                d[i - 1] =  d[i] + 1;
                nums[i - 1] = i;
            }
            if ((i % 3) == 0 && d[i / 3] > d[i] + 1) {
                d[i / 3] = d[i] + 1;
                nums[i / 3] = i;
            }
            if ((i % 2) == 0 && d[i / 2] > d[i] + 1) {
                d[i / 2] = d[i] + 1;
                nums[i / 2] = i;
            }
        }
        int[] res = new int[d[1] + 1];
        int j = 0;
        for (int i = 1; i != Integer.MAX_VALUE; i = nums[i]){
            res[j++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] res = new Calculator().findMinPath(n);

        System.out.println(res.length - 1);
        String output = Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
    }
}
