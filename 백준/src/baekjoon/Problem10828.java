package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10828 {

    private static int[] stack;
    private static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        stack = new int[num];

        while (num-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            switch (stringTokenizer.nextToken()) {

                case "push":
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;

                case "pop":
                    stringBuilder.append(pop()).append('\n');
                    break;

                case "size":
                    stringBuilder.append(size()).append('\n');
                    break;

                case "empty":
                    stringBuilder.append(empty()).append('\n');
                    break;

                case "top":
                    stringBuilder.append(top()).append('\n');
                    break;
            }
        }
            System.out.println(stringBuilder);
    }

    private static void push(int item) {
        stack[index] = item;
        index++;
    }

    private static int pop() {
        if (index == 0) {
            return -1;
        }
        int res = stack[index - 1];
        stack[index - 1] = 0;
        index--;
        return res;
    }

    private static int size() {
        return index;
    }

    private static int empty() {
        if (index == 0) {
            return 1;
        }
        return 0;
    }

    private static int top() {
        if (index == 0) {
            return -1;
        }

        return stack[index - 1];
    }
}
