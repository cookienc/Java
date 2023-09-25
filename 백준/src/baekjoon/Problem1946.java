package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1946
 */
public class Problem1946 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            int[][] result = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                final int first = Integer.parseInt(st.nextToken());
                final int second = Integer.parseInt(st.nextToken());
                result[i][0] = first;
                result[i][1] = second;
            }

            Arrays.sort(result, (r1, r2) -> {
                if (r1[0] == r2[0]) {
                    return r1[1] - r2[1];
                }
                return r1[0] - r2[0];
            });

            int highest = result[0][1];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (result[i][1] < highest) {
                    cnt++;
                    highest = result[i][1];
                }
            }
            System.out.println(cnt);
        }

    }
}

