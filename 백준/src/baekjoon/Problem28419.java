package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem28419 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long oddSum = 0;
        long evenSum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i % 2 == 1) {
                evenSum += arr[i];
                continue;
            }
            oddSum += arr[i];
        }

        if (N == 3 && Math.abs(oddSum) > Math.abs(evenSum)) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.abs(evenSum - oddSum));
    }
}
