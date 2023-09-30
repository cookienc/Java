package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem21967 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        final int[] counter = new int[11];
        final Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            final int cur = arr[i];
            deque.add(cur);
            counter[cur]++;
            final int max = findMax(counter);
            final int min = findMin(counter);

            if (max - min > 2) {
                final Integer first = deque.pollFirst();
                counter[first]--;
                continue;
            }

            answer = Math.max(answer, deque.size());
        }

        System.out.println(answer);
    }

    private static int findMin(final int[] counter) {
        for (int i = 1; i <= 10; i++) {
            if (counter[i] != 0) {
                return i;
            }
        }

        return -1;
    }

    private static int findMax(final int[] counter) {
        for (int i = 10; i > 0; i--) {
            if (counter[i] != 0) {
                return i;
            }
        }

        return -1;
    }
}
