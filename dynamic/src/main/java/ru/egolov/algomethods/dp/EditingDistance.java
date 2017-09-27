package ru.egolov.algomethods.dp;

import java.util.Collections;
import java.util.Scanner;

import static java.util.Arrays.asList;


/**
 * Minimum amount of characters edits (insertion, deletion, substitution)
 * to make string A be equal to string B.
 *
 * Sample Input 1:
 * ab
 * ab
 * Sample Output 1:
 * 0
 *
 *
 * Sample Input 2:
 * short
 * ports
 * Sample Output 2:
 * 3
 */
public class EditingDistance {

    private final String first;
    private final String second;
    private final int[][] d;

    public EditingDistance(String first, String second) {
        this.first = first;
        this.second = second;
        d = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); ++i) {
            for (int j = 0; j <= second.length(); ++j) {
                d[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public int calculate() {
        return calculate(first.length(), second.length());
    }

    private int calculate(int i, int j) {
        if (d[i][j] == Integer.MIN_VALUE) {
            if (i == 0) {
                d[i][j] = j;
            } else if (j == 0) {
                d[i][j] = i;
            } else {
                int ins = calculate(i, j - 1) + 1;
                int del = calculate(i - 1, j) + 1;
                int sub = calculate(i - 1, j - 1) + diff(i, j);
                d[i][j] = Collections.min(asList(ins, del, sub));
            }
        }
        return d[i][j];
    }

    private int diff(int i, int j) {
        return first.charAt(i - 1) == second.charAt(j - 1) ? 0 : 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EditingDistance ed = new EditingDistance(scanner.nextLine(), scanner.nextLine());
        System.out.println(ed.calculate());
    }
}
