package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> list = new ArrayList<>();
                
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Stack<Integer> reverseAnswer = decimalToB(b, aToDecimal(a, list));

        while (!reverseAnswer.isEmpty()) {
            stringBuilder.append(reverseAnswer.pop())
                    .append(" ");
        }

        System.out.println(stringBuilder);
    }

    private static Stack<Integer> decimalToB(int b, Integer number) {

        Stack<Integer> stack = new Stack<>();

        while (number != 0) {
            int temp = number % b;
            number /= b;
            stack.push(temp);
        }

        return stack;
    }

    private static Integer aToDecimal(int a, List<Integer> list) {
        Integer sum = 0;

        for (int i = 0; i < list.size() ; i++) {
            sum += list.get(i) * (int)(Math.pow(a, list.size() - (i + 1)));
        }

        return sum;
    }
}
