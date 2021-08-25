package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2522 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int num = Integer.parseInt(bufferedReader.readLine());
        int height = 2 * num - 1;

        for (int i = 1; i <= height; i++) {
            int star;
            int space;

            if (i <= num) {
                space = num - i;
                star = i;
            } else {
                space = i - num;
                star = 2 * num - i;
            }

            stringBuilder.append(" ".repeat(space))
                    .append("*".repeat(star))
                    .append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

}