package ru.egolov.algomethods.greedy.huffman;

import java.io.*;
import java.util.*;

public class Encoding {

    private abstract class Node implements Comparable<Node> {
        protected final int frequency;

        protected Node(int frequency) {
            this.frequency = frequency;
        }

        public abstract String code(char c, String aux);

        @Override
        public int compareTo(Node o) {
            return Integer.compare(frequency, o.frequency);
        }
    }

    private class InternalNode extends Node {
        private final Node left;
        private final Node right;

        protected InternalNode(Node left, Node right) {
            super(left.frequency + right.frequency);
            this.left = left;
            this.right = right;
        }

        @Override
        public String code(char c, String aux) {
            return left.code(c, aux + "0") + right.code(c, aux + "1");
        }
    }

    private class LeafNode extends Node {
        private final char c;

        protected LeafNode(int frequency, char c) {
            super(frequency);
            this.c = c;
        }

        @Override
        public String code(char c, String aux) {
            if (this.c != c) {
                return "";
            }
            return aux.length() == 0 ? "0" : aux;
        }
    }

    private final String input;
    private Node head;
    private int encodedLength;
    private final Map<Character, Integer> charsFrequency = new HashMap<>();
    private final Map<Character, String> charToCode = new HashMap<>();

    public Encoding(String input) {
        this.input = input;
        code();
    }

    private void code() {
        for (Character c : input.toCharArray()) {
            Integer existingCount = charsFrequency.putIfAbsent(c, 1);
            if (existingCount != null) {
                charsFrequency.put(c, existingCount + 1);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(charsFrequency.size());
        charsFrequency.forEach((ch,count) -> pq.add(new LeafNode(count, ch)));
        head = pq.peek();
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            InternalNode newInternalNode = new InternalNode(left, right);
            encodedLength += newInternalNode.frequency;
            head = newInternalNode;
            pq.add(newInternalNode);
        }

        List<Character> list = new ArrayList<>(charsFrequency.keySet());
        Collections.reverse(list);
        list.forEach(c -> charToCode.put(c, encoded(c)));
    }

    public int distinctCharsCount() {
        return charsFrequency.keySet().size();
    }

    public int encodedLength() {
        return encodedLength == 0 ? input.length() : encodedLength;
    }

    private String encoded(char c) {
        return head.code(c, "");
    }

    public Map<Character, String> getCodes() {
        return charToCode;
    }

    public String encoded() {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(charToCode.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteArrayInputStream bais = new ByteArrayInputStream("aaab".getBytes("utf-8"));
        run(bais, System.out);
    }

    private static void run(InputStream in, OutputStream out) {
        String input = new Scanner(in).nextLine();
        Encoding hc = new Encoding(input);

        PrintStream ps = new PrintStream(out);

        ps.println(String.format("%d %d", hc.distinctCharsCount(), hc.encodedLength()));
        hc.getCodes().forEach((character, code) -> ps.println(character + ": " + code));
        ps.println(hc.encoded());
    }
}
