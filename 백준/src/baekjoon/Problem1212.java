package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1212 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String word = bufferedReader.readLine();

        initializeStack(word, stack);

        Stack<String> reverseAnswer = new Stack<>();

        reverseAnswer = octalToBinary(stack);

        while (!reverseAnswer.isEmpty()) {
            stringBuilder.append(reverseAnswer.pop());
        }

        System.out.println(stringBuilder);
    }

    private static void initializeStack(String word, Stack<Character> stack) {
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
    }

    private static Stack<String> octalToBinary(Stack<Character> stack) {

        Stack<String> reverseStack = new Stack<>();

        while (stack.size() > 1) {
            switch (stack.pop()) {
                case '0':
                    reverseStack.push("000");
                    break;

                case '1':
                    reverseStack.push("001");
                    break;

                case '2':
                    reverseStack.push("010");
                    break;

                case '3':
                    reverseStack.push("011");
                    break;

                case '4':
                    reverseStack.push("100");
                    break;

                case '5':
                    reverseStack.push("101");
                    break;

                case '6':
                    reverseStack.push("110");
                    break;

                case '7':
                    reverseStack.push("111");
                    break;

            }
        }
        reverseStack.push(Integer.toBinaryString(stack.pop() - '0'));

        return reverseStack;
    }
}
