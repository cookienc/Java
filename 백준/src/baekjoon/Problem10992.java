package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10992 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100) {
            throw new Exception("오류");
        }

        stringBuilder.append(" ".repeat(space(1, num))).append("*").append(NEW_LINE);

        for (int i = 2; i < num; i++) {
            stringBuilder.append(" ".repeat(space(i, num)))
                    .append("*")
                    .append(" ".repeat(starMiddle(i, num)))
                    .append("*")
                    .append(NEW_LINE);
        }
        if (num > 1) {
           stringBuilder.append("*".repeat(2 * num - 1)).append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static int starMiddle(int i, int num) {
        if (num > 2 && i >= 2) {
            return 2 * (i - 1) - 1;
        } else {
            return 0;
        }
    }

    private static int space(int i, int num) {
        return num - i;
    }
}
