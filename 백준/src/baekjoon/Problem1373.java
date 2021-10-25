package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder stringBuilder = new StringBuilder();
        String n = stringTokenizer.nextToken();

        Stack<Character> stack = new Stack<>();

        initializeStack(n, stack);

        stack = binaryToOctal(n, stack);

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        System.out.println(stringBuilder);
    }

    private static void initializeStack(String n, Stack<Character> stack) {
        for (int i = 0; i < n.length(); i++) {
            stack.push(n.charAt(i));
        }
    }

    private static Stack<Character> binaryToOctal(String n, Stack<Character> stack) {

        Stack<Character> reverseStack = new Stack<>();

        int sum = 0;

        while (!stack.isEmpty()) {

            int first = 0;
            int second = 0;
            int third = 0;

            if (!stack.isEmpty()) {
                first = (stack.pop() - '0') * 1;
            }

            if (!stack.isEmpty()) {
                second = (stack.pop() - '0') * 2;
            }

            if (!stack.isEmpty()) {
                third = (stack.pop() - '0') * 4;
            }

            sum = first + second + third;

            reverseStack.push((char)(sum + '0'));
        }

        return reverseStack;
    }
}
