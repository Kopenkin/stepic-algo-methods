package ru.egolov.algomethods.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditingDistanceTest {

    @Test
    public void test() {
        EditingDistance ed = new EditingDistance("ab", "ab");
        assertEquals(0, ed.calculate());

        ed = new EditingDistance("short", "ports");
        assertEquals(3, ed.calculate());
    }
}
