package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1699 {

    private static Integer[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100000) {
            throw new Exception("오류");
        }

        dp = new Integer[num + 1];

        findMethod(num);

    }

    private static void findMethod(int num) {

        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[num]);

    }


}