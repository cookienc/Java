package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        String n = stringTokenizer.nextToken();
        int b = Integer.parseInt(stringTokenizer.nextToken());

        Stack<Character> stack = new Stack<>();

        initializeStack(n, stack);

        int sum = 0;

        sum = findDigit(n, b, stack, sum);

        System.out.println(sum);
    }

    private static void initializeStack(String n, Stack<Character> stack) {
        for (int i = 0; i < n.length(); i++) {
            stack.push(n.charAt(i));
        }
    }

    private static int findDigit(String n, int b, Stack<Character> stack, int sum) {
        for (int i = 0; i < n.length(); i++) {

            if (stack.peek() >= 'A' && stack.peek() <= 'Z') {
                sum += (int) (stack.pop() - 55) * Math.pow(b, i);
                continue;
            }

            sum += (stack.pop() - '0') * Math.pow(b, i);
        }
        return sum;
    }
}
