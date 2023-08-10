package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Problem28417 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a1 = Integer.parseInt(st.nextToken());
            final int a2 = Integer.parseInt(st.nextToken());
            final int b1 = Integer.parseInt(st.nextToken());
            final int b2 = Integer.parseInt(st.nextToken());
            final int b3 = Integer.parseInt(st.nextToken());
            final int b4 = Integer.parseInt(st.nextToken());
            final int b5 = Integer.parseInt(st.nextToken());
            final int[] array = Stream.of(b1, b2, b3, b4, b5)
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
            sum = Math.max(sum, Math.max(a1, a2) + array[3] + array[4]);
        }
        System.out.println(sum);
    }
}
