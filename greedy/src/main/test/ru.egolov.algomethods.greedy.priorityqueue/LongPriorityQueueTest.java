package ru.egolov.algomethods.greedy.priorityqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongPriorityQueueTest {

    private LongPriorityQueue pq = new LongPriorityQueue();

    @Test
    public void parentTest() {
        assertEquals(0, pq.parent(1));
        assertEquals(0, pq.parent(2));
        assertEquals(1, pq.parent(3));
        assertEquals(1, pq.parent(4));
        assertEquals(2, pq.parent(5));
        assertEquals(2, pq.parent(6));
    }

    @Test
    public void childsTest() {
        assertEquals(1, pq.leftChild(0));
        assertEquals(3, pq.leftChild(1));
        assertEquals(5, pq.leftChild(2));

        assertEquals(2, pq.rightChild(0));
        assertEquals(4, pq.rightChild(1));
        assertEquals(6, pq.rightChild(2));
    }

    @Test
    public void insertTest() {
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        assertEquals(3, pq.size());
        assertEquals(3, pq.get(0));
        assertEquals(1, pq.get(1));
        assertEquals(2, pq.get(2));

        pq = new LongPriorityQueue();
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        assertEquals(3, pq.size());
        assertEquals(3, pq.get(0));
        assertEquals(2, pq.get(1));
        assertEquals(1, pq.get(2));
    }

    @Test
    public void extractMaxTest() {
        pq.insert(1);
        assertEquals(1, pq.extractMax());
        assertEquals(0, pq.extractMax());

        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        assertEquals(3, pq.extractMax());
        assertEquals(2, pq.extractMax());
        assertEquals(1, pq.extractMax());
    }

    @Test
    public void insertExtractTest() {
//        Insert 200
//        Insert 10
//        Insert 5
//        Insert 500
        pq.insert(200);
        pq.insert(10);
        pq.insert(5);
        pq.insert(500);
        assertEquals(500, pq.extractMax());
        assertEquals(200, pq.extractMax());
        assertEquals(10, pq.extractMax());
        assertEquals(5, pq.extractMax());

    }
}
