package ru.egolov.algomethods.greedy.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primitive priority queue implementation.
 * Only longs support.
 * todo: expand and generify solution
 */
public class LongPriorityQueue {

    private List<Long> heap = new ArrayList<>();

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }

    public void insert(long val) {
        int insertionPlace = heap.size();
        heap.add(val);
        siftUp(insertionPlace);
    }

    public int size() {
        return heap.size();
    }

    public long get(int i) {
        return heap.get(i);
    }

    public long extractMax() {
        if (heap.size() == 0) {
            return 0;
        }
        long maxValue = heap.get(0);
        long lastValue = heap.get(heap.size() - 1);
        heap.set(0, lastValue);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return maxValue;
    }

    private void siftUp(int i) {
        while (parent(i) >= 0 && heap.get(parent(i)) < heap.get(i)) {
            long current = heap.get(i);
            long parent = heap.get(parent(i));
            heap.set(parent(i), current);
            heap.set(i, parent);
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        while (
            leftChild(i) <= heap.size() - 1 && heap.get(leftChild(i)) > heap.get(i)
            || rightChild(i) <= heap.size() - 1 && heap.get(rightChild(i)) > heap.get(i)
        ) {
            int maxIndex = i;
            long curr = heap.get(i);
            long leftChild = heap.get(leftChild(i));
            long rightChild = rightChild(i) < heap.size() ? heap.get(rightChild(i)) : curr;

            long max = Math.max(curr, leftChild);
            if (max != curr) {
                maxIndex = leftChild(i);
            }
            max = Math.max(max, rightChild);
            if (max != curr && max != leftChild) {
                maxIndex = rightChild(i);
            }
            if (maxIndex != i) {
                heap.set(i, max);
                heap.set(maxIndex, curr);
                i = maxIndex;
            }
        }
    }

//    for stepic testing purposes
    public static void main(String[] args) {
        final LongPriorityQueue pq = new LongPriorityQueue();
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commands; ++i) {
            String[] command = scanner.nextLine().split(" ");
            if (command.length > 1) {
                pq.insert(Long.parseLong(command[1]));
            } else {
                System.out.println(pq.extractMax());
            }
        }
    }
}
