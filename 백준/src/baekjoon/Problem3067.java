package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3067 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            final int M = Integer.parseInt(br.readLine());

            final int[] dp = new int[10001];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                final int curCoin = coins[i];

                for (int j = curCoin; j <= M; j++) {
                    dp[j] += dp[j - curCoin];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
