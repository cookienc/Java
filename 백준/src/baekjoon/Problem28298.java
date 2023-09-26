package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/28298
 */
public class Problem28298 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        char[][] tiles = new char[N][M];
        for (int r = 0; r < N; r++) {
            final char[] arr = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                tiles[r][c] = arr[c];
            }
        }

        int answer = 0;
        for (int r = 0; r < K; r++) {
            for (int c = 0; c < K; c++) {
                final Map<Character, Integer> map = new HashMap<>();
                for (int rr = r; rr < N; rr += K) {
                    for (int cc = c; cc < M; cc += K) {
                        map.merge(tiles[rr][cc], 1, Integer::sum);
                    }
                }

                char maxKey = ' ';
                int max = -1;
                for (final Map.Entry<Character, Integer> entry : map.entrySet()) {
                    final Character key = entry.getKey();
                    final Integer value = entry.getValue();

                    if (max < value) {
                        max = value;
                        maxKey = key;
                    }
                }

                for (int rr = r; rr < N; rr += K) {
                    for (int cc = c; cc < M; cc += K) {
                        if (maxKey != tiles[rr][cc]) {
                            answer++;
                        }
                        tiles[rr][cc] = maxKey;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(tiles[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
