package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2446 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100) {
            throw new Exception("오류");
        }

        int height = 2 * num - 1;

        for (int i = 1; i <= height; i++) {
            stringBuilder.append(" ".repeat(space(i, num)))
                    .append("*".repeat(star(i, num)))
                    .append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static int star(int i, int num) {
        if (i <= num) {
            return 2 * (num - i + 1) - 1;
        } else {
            return 2 * (i - num) + 1;
        }
    }

    private static int space(int i, int num) {
        if (i <= num) {
            return i - 1;
        } else {
            return 2 * num - i - 1;
        }
    }
}
