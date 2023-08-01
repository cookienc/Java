package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25186 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] clothes = new int[N];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            clothes[i] = Integer.parseInt(st.nextToken());
            sum += clothes[i];
            max = Math.max(max, clothes[i]);
        }

        if (sum == 1) {
            System.out.println("Happy");
            return;
        }

        if (sum - max >= max) {
            System.out.println("Happy");
            return;
        }
        System.out.println("Unhappy");
    }
}
