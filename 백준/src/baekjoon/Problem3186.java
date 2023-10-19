package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3186 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        final String p = br.readLine();
        final Queue<Integer> person = new LinkedList<>();
        for (int second = 0; second < N; second++) {
            final int fill = p.charAt(second) - '0';
            person.add(fill);
        }

        boolean use = false;
        int fill = 0;
        int empty = 0;
        int time = 0;
        int lastUseTime = 0;
        final StringBuilder sb = new StringBuilder();
        while (!person.isEmpty()) {
            time++;
            final Integer cur = person.poll();
            if (cur == 1) {
                fill++;
                empty = 0;
                lastUseTime = time;
            } else {
                fill = 0;
                empty++;
            }

            if (fill >= K) {
                use = true;
            }

            if (use && empty >= L) {
                use = false;
                empty = 0;
                fill = 0;
                sb.append(time).append("\n");
            }
        }

        if (use) {
            sb.append(lastUseTime + L).append("\n");
        }

        System.out.println(sb.length() == 0 ? "NIKAD" : sb);
    }
}
