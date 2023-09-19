package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem14594 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1];
        Arrays.fill(array, 0);
        int cnt = 0;
        int answer = 0;

        int[][] command = new int[M][2];
        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());
            command[i][0] = x;
            command[i][1] = y;
        }
        Arrays.sort(command, Comparator.comparing(c -> c[0]));

        for (int j = 0; j < M; j++) {
            cnt++;
            final int x = command[j][0];
            final int y = command[j][1];

            for (int i = x; i <= y; i++) {
                if (i == x && array[i] == 0) {
                    answer++;
                }
                array[i] = cnt;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (array[i] == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
