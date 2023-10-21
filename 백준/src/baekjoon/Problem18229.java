package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18229 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final int[][] lengths = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                final int length = Integer.parseInt(st.nextToken());
                lengths[n][m] = length;
            }
        }

        final int[] sum = new int[N];
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                sum[n] += lengths[n][m];
                if (sum[n] >= K) {
                    System.out.println((n + 1) + " " + (m + 1));
                    System.exit(0);
                }
            }
        }
    }
}
