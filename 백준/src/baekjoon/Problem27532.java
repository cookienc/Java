package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem27532 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int M = Integer.parseInt(br.readLine());

        int[] time = new int[M];
        for (int i = 0; i < M; i++) {
            final String t = br.readLine();
            final String[] split = t.split(":");
            final int hour = (Integer.parseInt(split[0]) - 1) * 60;
            final int minute = Integer.parseInt(split[1]);
            time[i] = hour + minute;
        }

        if (M == 1) {
            System.out.println(1);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int r = 1; r <= 720; r++) {
            final int[] copyTime = Arrays.copyOf(time, time.length);
            for (int i = 0; i < M; i++) {
                int diff = i * r;
                while (diff >= 720) {
                    diff -= 720;
                }
                if (copyTime[i] >= diff) {
                    copyTime[i] -= diff;
                } else {
                    copyTime[i] += 720 - diff;
                }
            }

            final int count = (int) Arrays.stream(copyTime)
                    .distinct()
                    .count();

            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
