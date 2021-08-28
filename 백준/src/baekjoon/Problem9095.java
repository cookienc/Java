package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem9095 {

    private static final String NEW_LINE = "\n";

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        dp = new int[12];

        int num;

        try {
            for (int i = 0; i < n; i++) {
                num = Integer.parseInt(bufferedReader.readLine());
                stringBuilder.append(findMethod(num)).append(NEW_LINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder);
    }

    private static int findMethod(int num) {

        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 2;
        }

        if (num == 3) {
            return 4;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        return dp[num] = findMethod(num - 1) + findMethod(num - 2)
                + findMethod(num - 3);
    }
}
