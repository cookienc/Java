package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2225 {

    private static int[][] dp = new int[201][201];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        if (n < 1 || n > 200) {
            throw new Exception("오류");
        }

        if (k < 1 || k > 200) {
            throw new Exception("오류");
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }

        System.out.println(dp[n][k]);

    }
}
