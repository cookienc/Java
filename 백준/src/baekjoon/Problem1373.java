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

        String n = stringTokenizer.nextToken();

        Stack<Character> stack = new Stack<>();

        initializeStack(n, stack);

        long sum = 0;

        sum = binaryToDecimal(n, stack, sum);

        String answer = Long.toOctalString(sum);

        System.out.println(answer);
    }

    private static void initializeStack(String n, Stack<Character> stack) {
        for (int i = 0; i < n.length(); i++) {
            stack.push(n.charAt(i));
        }
    }

    private static long binaryToDecimal(String n, Stack<Character> stack, long sum) {
        for (int i = 0; i < n.length(); i++) {

            sum += (stack.pop() - '0') * Math.pow(2, i);
        }
        return sum;
    }
}
