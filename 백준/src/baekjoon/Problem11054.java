package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11054 {

    private static int[] dpLeft;
    private static int[] dpRight;
    private static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("오류");
        }

        dpLeft = new int[num + 1];
        dpRight = new int[num + 1];
        array = new int[num + 1];

        initializeArray(bufferedReader, num);

        LIS(num);
        LDS(num);

        System.out.println(getMax(num));

    }

    private static int getMax(int num) {
        int[] dp = findBitonic(num);

        int max = dp[1];

        for (int i = 2; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int[] findBitonic(int num) {
        int[] dp = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            dp[i] = dpLeft[i] + dpRight[i] - 1;
        }
        return dp;
    }

    private static int LDS(int num) {

        Arrays.fill(dpRight, 1);

        for (int i = num; i > 0; i--) {
            for (int j = num; j > i; j--) {
                if (array[j] < array[i] && dpRight[j] >= dpRight[i]) {
                    dpRight[i] = dpRight[j] + 1;
                }
            }
        }

        return dpRight[num];
    }

    private static void LIS(int num) {

        Arrays.fill(dpLeft, 1);

        for (int i = 1; i <= num; i++){
            for (int j = 1 ; j < i; j++){
                if (array[j] < array[i] && dpLeft[j] >= dpLeft[i]){
                    dpLeft[i] = dpLeft[j] + 1;
                }
            }
        }
    }

    private static void initializeArray(BufferedReader bufferedReader, int num) throws IOException {

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }
}
