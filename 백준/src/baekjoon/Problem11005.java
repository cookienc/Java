package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        Stack<Integer> stack = new Stack<>();

        while (n != 0) {
            stack.push(n % b);
            n /= b;
        }

        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            if (num >= 10) {
                stringBuilder.append((char)(num + 55));
            } else {
                stringBuilder.append(num);
            }
        }

        System.out.println(stringBuilder);
    }
}
