package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        Stack<Character> stack = new Stack<Character>();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            stack.pop();

            if (str.charAt(i - 1) == '(') {
                sum += stack.size();
            } else {
                sum++;
            }
        }

        System.out.println(sum);

    }

}
