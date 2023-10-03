package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class Problem14469 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int arrivalTime = Integer.parseInt(st.nextToken());
            final int examinationTime = Integer.parseInt(st.nextToken());
            cows[i][0] = arrivalTime;
            cows[i][1] = examinationTime;
        }

        Arrays.sort(cows, comparingInt(c -> c[0]));

        int total = 0;
        for (int i = 0; i < N; i++) {
            if (total <= cows[i][0]) {
                total = cows[i][0] + cows[i][1];
                continue;
            }

            total += cows[i][1];
        }

        System.out.println(total);
    }
}
