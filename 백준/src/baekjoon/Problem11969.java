package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11969 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());

        int[] cows = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        int[][] sum = new int[N + 1][4];
        for (int i = 1; i < N + 1; i++) {
            sum[i][1] += sum[i - 1][1];
            sum[i][2] += sum[i - 1][2];
            sum[i][3] += sum[i - 1][3];
            if (cows[i] == 1) {
                sum[i][1]++;
                continue;
            }

            if (cows[i] == 2) {
                sum[i][2]++;
                continue;
            }

            sum[i][3]++;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            sb.append(sum[b][1] - sum[a - 1][1]).append(" ")
                    .append(sum[b][2] - sum[a - 1][2]).append(" ")
                    .append(sum[b][3] - sum[a - 1][3]).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
