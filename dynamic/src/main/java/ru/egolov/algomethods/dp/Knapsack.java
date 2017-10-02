package ru.egolov.algomethods.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1 4 8 -> 9
 */
public class Knapsack {

    /**
     *
     * @param W knapsack capacity
     * @param weights of golden bars
     * @return maximum total weight of golden bars in a knapsack with specified capacity
     */
    public int maxCost(int W, int[] weights) {
        int n = weights.length;
        int[][] d = new int[W + 1][n + 1];
        for (int w = 0; w <= W; ++w) {
            d[w][0] = 0;
        }
        for (int i = 0; i <= n; ++i) {
            d[0][i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int w = 1; w <= W; ++w) {
                d[w][i] = d[w][i - 1];
                int wi = weights[i - 1];
                if (wi <= w) {
                    d[w][i] = Math.max(d[w][i], d[w - wi][i - 1] + wi);
                }
            }
        }
        return d[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int[] weights = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = new Knapsack().maxCost(capacity, weights);
        System.out.println(res);
    }
}
