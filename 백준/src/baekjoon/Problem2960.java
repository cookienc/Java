package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2960
 */
public class Problem2960 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        int cnt = 0;
        for (int i = 2; i < N + 1; i++) {
            for (int j = i; j < N + 1; j += i) {
                if (isVisited[j]) {
                    continue;
                }

                isVisited[j] = true;
                if (++cnt == K) {
                    System.out.println(arr[j]);
                }
            }
        }
    }
}
