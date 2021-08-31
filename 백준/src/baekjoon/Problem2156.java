package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2156 {

    private static Integer[] dp;
    private static int[] wine;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 10000) {
            throw new Exception("오류");
        }


        dp = new Integer[num + 1];
        wine = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            wine[i] = Integer.parseInt(bufferedReader.readLine());
        }

        initializeDp(num);

        System.out.println(findMethod(num));
    }

    private static void initializeDp(int num) {
        dp[0] = 0;
        dp[1] = wine[1];

        if(num > 1) {
            dp[2] = wine[1] + wine[2];
        }
    }

    private static int findMethod(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(Math.max(findMethod(num - 2), findMethod(num - 3) + wine[num - 1]) + wine[num], findMethod(num - 1));
        }

        return dp[num];
    }
}
