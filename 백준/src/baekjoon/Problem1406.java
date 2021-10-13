package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        String word = bufferedReader.readLine();

        Stack<Character> lStack = new Stack();
        Stack<Character> rStack = new Stack();

        initialize(word, lStack);

        int num = Integer.parseInt(bufferedReader.readLine());

        while (num-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String command = stringTokenizer.nextToken();

            switch (command) {

                case "L":
                    if (lStack.isEmpty()) {
                        break;
                    }

                    rStack.add(lStack.pop());
                    break;

                case "D":
                    if (rStack.isEmpty()) {
                        break;
                    }
                    lStack.add(rStack.pop());
                    break;

                case "B":
                    if (lStack.isEmpty()) {
                        break;
                    }
                    lStack.pop();
                    break;

                case "P":
                    lStack.add(stringTokenizer.nextToken().charAt(0));
                    break;
            }
        }

        while (!lStack.isEmpty()) {
            rStack.add(lStack.pop());
        }

        while (!rStack.isEmpty()) {
            stringBuilder.append(rStack.pop());
        }

        System.out.println(stringBuilder);
    }

    private static void initialize(String word, List words) {
        for (int i = 0; i < word.length(); i++) {
            words.add(word.charAt(i));
        }
    }
}
