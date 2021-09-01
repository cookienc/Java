package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11053 {

    private static int[] array;
    private static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("범위 오류");
        }

        array = new int[num + 1];
        dp = new Integer[num + 1];

        Arrays.fill(dp, 1);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        initializeDp(num);

        System.out.println(findMaxValue(num));
    }

    private static int findMaxValue(int num) {
        int max = dp[1];

        for (int i = 2; i <= num; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    private static void initializeDp(int num) {
        for(int i = 1; i <= num; i++){
            for(int j = 1 ; j <= i; j++){
                if(array[j] < array[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
}

