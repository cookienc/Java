package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2579 {

    private static int[] array;
    private static Integer[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 300) {
            throw new Exception("오류");
        }

        array = new int[num + 1];
        dp = new Integer[num + 1];

        inputData(bufferedReader, num);

        dp[0] = 0;
        dp[1] = array[1];

        if (num > 1) {
            dp[2] = array[1] + array[2];
        }

        System.out.println(findDp(num));
    }

    private static void inputData(BufferedReader bufferedReader, int num) throws IOException {
        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private static int findDp(int num) {

        if (dp[num] == null) {
            dp[num] = Math.max(findDp(num - 2), findDp(num - 3) + array[num - 1]) + array[num];
        }
        return dp[num];
    }
}