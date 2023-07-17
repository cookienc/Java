package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1106 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int C = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int pay = Integer.parseInt(st.nextToken());
            final int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < C + 100; j++) {
                if (dp[j - people] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - people] + pay);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = C; i <= C + 100; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);
    }
}
