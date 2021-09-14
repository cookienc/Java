package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2011 {

    private static int[] dp;
    private static int mod = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        int length = input.length();

        dp = new int[length + 1];

        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            int num = input.charAt(i - 1) - '0';
            if (1 <= num && num <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }

            if (i == 1) {
                continue;
            }

            if ((input.charAt(i - 2) - '0') == 0) {
                continue;
            }

            int prev = (input.charAt(i - 2) - '0') * 10;
            int curr = input.charAt(i - 1) - '0';

            if (prev + curr <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }

        System.out.println(dp[length]);
    }
}
