package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem28066 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        final int deleteSize = K - 1;
        if (N == K) {
            System.out.println(K);
            return;
        }

        while (queue.size() != 1) {
            if (queue.size() < K) {
                System.out.println(queue.poll());
                return;
            }

            queue.offer(queue.poll());

            for (int i = 0; i < deleteSize; i++) {
                queue.poll();
            }
        }

        System.out.println(queue.poll());
    }
}
