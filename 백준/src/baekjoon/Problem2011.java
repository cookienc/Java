package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2011 {

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String tmp = bufferedReader.readLine();

        int length = tmp.length();

        int num = Integer.parseInt(tmp);


        dp = new int[length + 1];

        dp[0] = 1;

        if ((tmp.charAt(0) >= '1' && tmp.charAt(0) <= '2') &&
                (tmp.charAt(1) >= '1' && tmp.charAt(1) <= '6')) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        if (tmp.charAt(0) == '0' ||
                ((tmp.charAt(tmp.length() - 1) == '0') &&
                        tmp.charAt(tmp.length() - 2) > '2')) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i < length; i++) {

            char idx = tmp.charAt(i);
            char preIdx = tmp.charAt(i - 1);

            if ((idx >= '1' && idx <= '6') &&
                    (preIdx >= '1' && preIdx <= '2')) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[length - 1]);
    }
}
