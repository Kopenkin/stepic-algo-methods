package ru.egolov.algomethods.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StairwayTest {

    private final Stairway stairway = new Stairway();

    @Test
    public void test() {
        assertEquals(3, stairway.maxSum(new int[] {1, 2}));
        assertEquals(1, stairway.maxSum(new int[] {2, -1}));
        assertEquals(3, stairway.maxSum(new int[] {-1, 2, 1}));
        assertEquals(9, stairway.maxSum(new int[] {5, -1, -2, 5}));
    }
}
