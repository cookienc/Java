package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2193 {

    private static long[] dp = new long[91];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int digit = Integer.parseInt(bufferedReader.readLine());

        if (digit < 1 || digit > 90) {
            throw new Exception("오류");
        }

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        System.out.println(findMethod(digit));


    }

    private static long findMethod(int digit) {

        if (dp[digit] != 0) {
            return dp[digit];
        }

        return dp[digit] = findMethod(digit - 1) + findMethod(digit - 2);

    }
}
