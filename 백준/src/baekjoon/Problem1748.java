package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1748
 */
public class Problem1748 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /**
         * 1 2 3 4 5 6 7 8 9 -> 9 * 1
         * 10 11 12 13 14 15 ... 99 -> 90 * 2
         * 100 101 ... 999 -> 900 * 3
         */
        long cnt = 0;
        final int length = String.valueOf(N).length();
        for (int i = 1; i < length; i++) {
            cnt += 9 * Math.pow(10, i - 1) * i;
        }

        final int start = (int) Math.pow(10, length - 1);
        for (int i = start; i <= N; i++) {
            cnt += length;
        }

        System.out.println(cnt);
    }
}
