package ru.egolov.algomethods.dp;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void test() {
        assertArrayEquals(new int [] {1}, calculator.findMinPath(1));
        assertArrayEquals(new int [] {1, 3, 4}, calculator.findMinPath(4));
        assertArrayEquals(new int [] {1, 3, 4, 5}, calculator.findMinPath(5));
        assertArrayEquals(
            new int [] {1, 3, 9, 10, 11, 33, 99, 297, 891, 2673, 8019, 16038, 16039, 48117, 96234},
            calculator.findMinPath(96234)
        );
    }
}
