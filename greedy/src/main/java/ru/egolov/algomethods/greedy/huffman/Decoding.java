package ru.egolov.algomethods.greedy.huffman;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoding {
    private Map<String, Character> codeToChar;

    public static void main(String[] args) throws FileNotFoundException {
        Decoding hd = new Decoding();
//        hd.run(new FileInputStream("input.txt"), System.out);
        hd.run(System.in, System.out);
    }

    private void run(InputStream in, OutputStream out) {
        Scanner scanner = new Scanner(in);
        readCodes(scanner);
        String decoded = decode(scanner.nextLine());
        new PrintStream(out).println(decoded);
    }

    private String decode(String encoded) {
        StringBuilder result = new StringBuilder();
        while (encoded.length() > 0) {
            int to = 1;
            Character character = codeToChar.get(encoded.substring(0, to));
            while (character == null) {
                to++;
                character = codeToChar.get(encoded.substring(0, to));
            }
            encoded = encoded.substring(to);
            result.append(character);
        }
        return result.toString();
    }

    private void readCodes(final Scanner scanner) {
        String[] firstLine = scanner.nextLine().split(" ");
        int size = Integer.parseInt(firstLine[0]);
        codeToChar = new HashMap<>(size);
        for (int i = 0; i < size; ++i) {
            String[] charToCodeInput = scanner.nextLine().split(": ");
            codeToChar.put(charToCodeInput[1], charToCodeInput[0].charAt(0));
        }
    }
}
