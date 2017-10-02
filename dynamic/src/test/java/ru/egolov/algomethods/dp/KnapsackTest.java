package ru.egolov.algomethods.dp;

import org.junit.Test;

public class KnapsackTest {

    private final Knapsack knapsack = new Knapsack();

    @Test
    public void test() {
        System.out.println(knapsack.maxCost(10, new int[]{1, 4, 8}));
    }
}
