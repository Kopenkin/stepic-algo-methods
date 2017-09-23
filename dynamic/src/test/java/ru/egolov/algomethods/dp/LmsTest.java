package ru.egolov.algomethods.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LmsTest {

    private LongestMultipleSubsequence lms = new LongestMultipleSubsequence();

    @Test
    public void test() {
        assertEquals(5, lms.lms(new long[] {3, 6, 7, 12, 24, 1, 1, 24}));
        assertEquals(3, lms.lms(new long[] {1, 1, 1}));
        assertEquals(6, lms.lms(new long[] {3, 6, 12, 24, 24, 24}));
    }
}
