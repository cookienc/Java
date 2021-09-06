package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2133 {

    private static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 30) {
            throw new Exception("오류");
        }

        dp = new int[num + 1];

        dp[0] = 1;

        System.out.println(findDp(num));
    }

    private static int findDp(int num) {

        for (int i = 2; i <= num; i++) {

            if (i % 2 != 0) {
                dp[i] = 0;
                continue;
            }
            dp[i] += dp[i - 2] * 3;

            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }
        return dp[num];
    }
}
