package ru.egolov.algomethods.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Stairway {

    /**
     *
     * @param steps price of each step
     * @return maximum price of walking step by step. Available moves: 1) next step; 2) second next step
     */
    public int maxSum(int[] steps) {
        if (steps.length < 2) return steps[0];
        int twoAgo = steps[0];
        int oneAgo = Math.max(steps[1], steps[0] + steps[1]);
        int max = oneAgo;
        for (int i = 2; i < steps.length; ++i) {
            max = Math.max(twoAgo, oneAgo) + steps[i];
            twoAgo = oneAgo;
            oneAgo = max;
        }
        return max;
    }

    public int maxSumD(int[] steps) {
        int n = steps.length;
        if (n < 2) return steps[0];

        int[] d = new int[n];
        d[0] = steps[0];
        d[1] = Math.max(steps[1], steps[0] + steps[1]);
        for (int i = 2; i < n; ++i) {
            d[i] = Math.max(d[i - 1], d[i - 2]) + steps[i];
        }
        return d[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] stepsWeight = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stairway stairway = new Stairway();
        System.out.println(stairway.maxSum(stepsWeight));
    }
}
