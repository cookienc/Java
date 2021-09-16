package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11052 {

    private static int[] dp;
    private static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("범위 오류");
        }

        dp = new int[num + 1];
        array = new int[num + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dp[0] = 0;
        dp[1] = array[1];

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + array[j]);
            }
        }

        System.out.println(dp[num]);
    }
}

