package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11722 {

    private static Integer[] dp;
    private static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("오류");
        }

        dp = new Integer[num + 1];
        array = new int[num + 1];

        initializeArray(num, bufferedReader);

        System.out.println(getMax(findMethod(num)));

    }

    private static int getMax(int method) {
        int max = dp[1];

        for (int i = 2; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private static int findMethod(int num) {

        Arrays.fill(dp, 1);

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                if (array[j] > array[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        return dp[num];
    }

    private static void initializeArray(int num, BufferedReader bufferedReader) throws IOException {

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }
}
