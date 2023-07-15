package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem22993 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long flag = Long.parseLong(st.nextToken());
        long[] power = new long[N - 1];
        for (int i = 0; i < power.length; i++) {
            power[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(power);
        int cnt = 0;
        for (final long p : power) {
            if (flag > p) {
                flag += p;
                cnt++;
            }
        }

        System.out.println(cnt == N - 1 ? "Yes" : "No");
    }
}
