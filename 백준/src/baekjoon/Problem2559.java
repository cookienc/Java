package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2559 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        temperature[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < temperature.length; i++) {
            final int cur = Integer.parseInt(st.nextToken());
            temperature[i] = temperature[i - 1] + cur;
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i < temperature.length; i++) {
            final int value = temperature[i] - temperature[i - K];
            max = Math.max(value, max);
        }
        System.out.println(max);
    }
}
