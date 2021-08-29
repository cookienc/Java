package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11057 {

    private static final int MOD = 10007;
    public static int[][] dp = new int[1001][10];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int digit = Integer.parseInt(bufferedReader.readLine());

        if (digit < 1 || digit > 1000) {
            throw new Exception("오류");
        }

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += findMethod(digit, i);
        }

        System.out.println(sum % MOD);

    }

    private static int findMethod(int digit, int i) {

        if (dp[digit][i] != 0) {
            return dp[digit][i] % MOD;
        }

        for (int j = i; j < 10; j++) {
            dp[digit][i] += (findMethod(digit - 1, j) % MOD);
        }

        return dp[digit][i] % MOD;
    }
}
