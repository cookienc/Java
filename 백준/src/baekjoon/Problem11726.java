package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11726 {

    private static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if (num < 1 || num > 1000) {
            throw new Exception("범위 오류");
        }

        if (num == 1) {
            System.out.println(1);
        } else if (num == 2) {
            System.out.println(2);
        } else {
            System.out.println(findMethod(num));
        }
    }

    private static int findMethod(int num) {

        dp =new int[num];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 3; i <= num; i++) {
            dp[i - 1] = (dp[i - 2] + dp[i - 3]) % 10007;
        }

        return dp[num - 1];
    }
}
