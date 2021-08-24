package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2438 {

    private static String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100) {
            throw new Exception("오류");
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                stringBuilder.append("*");
            }
            stringBuilder.append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }
}
