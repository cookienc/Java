package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14465 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] lights = new boolean[N];
        Arrays.fill(lights, true);
        while (B-- > 0) {
            final int wrong = Integer.parseInt(br.readLine()) - 1;
            lights[wrong] = false;
        }

        int lo = 0;
        int hi = -1;
        int fix = 0;
        int answer = Integer.MAX_VALUE;
        while (hi < N) {
            if (hi - lo != K - 1) {
                hi++;
                if (!lights[hi]) {
                    fix++;
                }
                continue;
            }

            answer = Math.min(answer, fix);
            if (!lights[lo++]) {
                fix--;
            }

            hi++;
            if (hi < N && !lights[hi]) {
                fix++;
            }

        }
        System.out.println(answer);
    }
}
