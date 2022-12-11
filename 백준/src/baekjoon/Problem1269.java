package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1269
 */
public class Problem1269 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Set<Integer> nSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> mSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mSet.add(Integer.parseInt(st.nextToken()));
        }

        nSet.retainAll(mSet);
        System.out.println(N + M - 2 * nSet.size());
    }
}
