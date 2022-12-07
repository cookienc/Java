package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3036
 */
public class Problem3036 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            final int gcd = gcd(map[0], map[i]);
            System.out.println(String.format("%d/%d", map[0] / gcd, map[i] / gcd));
        }
    }

    private static int gcd(final int a, final int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
