package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2669
 */
public class Problem2669 {
    private static boolean[][] map;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[101][101];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int r1 = Integer.parseInt(st.nextToken());
            final int c1 = Integer.parseInt(st.nextToken());
            final int r2 = Integer.parseInt(st.nextToken());
            final int c2 = Integer.parseInt(st.nextToken());

            for (int j = r1; j < r2; j++) {
                for (int k = c1; k < c2; k++) {
                    map[j][k] = true;
                }
            }
        }

        int cnt = 0;
        for (boolean[] booleans : map) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
