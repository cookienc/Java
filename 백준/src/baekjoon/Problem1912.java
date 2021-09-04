package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1912 {

    private static int[] array;
    private static Integer[] dp;
    private static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 100000) {
            throw new Exception("오류");
        }

        array = new int[num + 1];
        dp = new Integer[num + 1];

        inputData(bufferedReader, num);

        dp[0] = 0;
        dp[1] = array[1];

        findDp(num);

        getMaxValue();
    }

    private static void getMaxValue() {
        max = array[1];

        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }


    private static int findDp(int num) {

        if (dp[num] == null) {
            dp[num] = Math.max(array[num], findDp(num - 1) + array[num]);
        }

        return dp[num];

    }

    private static void inputData(BufferedReader bufferedReader, int num) throws IOException {

        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }
}