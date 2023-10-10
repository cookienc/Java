package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem22233 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final Set<String> src = new HashSet<>();
        for (int i = 0; i < N; i++) {
            src.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            final String[] split = br.readLine().split(",", -1);
            for (final String s : split) {
                src.remove(s);
            }
            System.out.println(src.size());
        }
    }
}
