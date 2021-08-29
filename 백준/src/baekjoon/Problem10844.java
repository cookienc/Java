package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem10844 {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for(int i = 1; i <= 9; i++) {
            result += findMethod(N, i);
        }
        System.out.println(result % MOD);
    }

    static long findMethod(int digit, int num) {

        if(digit == 1) {
            return dp[digit][num];
        }

        if(dp[digit][num] == null) {
            if (num == 0) {
                return dp[digit][num] = findMethod(digit - 1 ,1);
            }

            if (num== 9) {
                return dp[digit][num] = findMethod(digit - 1, 8);
            }

            return dp[digit][num] = findMethod(digit - 1, num - 1) + findMethod(digit - 1, num + 1);

        }
        return dp[digit][num] % MOD;
    }
}