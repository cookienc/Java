package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11727 {

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("오류");
        }

        dp = new int[num + 1];

        System.out.println(findMethod(num));


    }

    private static int findMethod(int num) {

        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 3;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        return dp[num] = (findMethod(num - 1) + 2 * findMethod(num - 2)) % 10007;
    }
}
