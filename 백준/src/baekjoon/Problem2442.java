package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2442 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100) {
            throw new Exception("오류");
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                stringBuilder.append(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                stringBuilder.append("*");
            }
            stringBuilder.append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }
}