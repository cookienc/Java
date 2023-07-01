package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;

public class Problem23757 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> present = new PriorityQueue<>(reverseOrder());
        Deque<Integer> child = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            present.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            child.add(Integer.parseInt(st.nextToken()));
        }

        boolean satisfied = true;
        for (int i = 0; i < M; i++) {
            final Integer want = child.pollFirst();
            if (want > present.peek()) {
                satisfied = false;
                break;
            }

            final Integer p = present.poll();
            present.add(p - want);
        }

        System.out.println(satisfied ? 1 : 0);
    }

}
