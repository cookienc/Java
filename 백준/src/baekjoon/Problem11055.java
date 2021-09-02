package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11055 {

    private static Integer[] dp;
    private static int[] array;
    private static int max = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("오류");
        }

        dp = new Integer[num + 1];
        array = new int[num + 1];

        Arrays.fill(dp, 0);
        dp[1] = 1;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        initializeArray(num, stringTokenizer);

        for(int i = 1; i <= num; i++) {

            dp[i] = array[i];

            for(int j = 1; j < i; j++) {
                if (array[j] < array[i] && dp[i] < dp[j] + array[i]) {
                    dp[i] = dp[j] + array[i];
                }
            }

            if(max < dp[i]) {
                max = dp[i];
            }

        }

        System.out.println(max);

    }

        private static void initializeArray(int num, StringTokenizer stringTokenizer) {
        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = array[i];
        }
    }
}
