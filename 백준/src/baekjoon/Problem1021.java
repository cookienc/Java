package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1021
 */
public class Problem1021 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            final int pick = deque.indexOf(arr[i]);

            final int firstDiff = pick;
            final int lastDiff = deque.size() - pick;
            if (firstDiff > lastDiff) {
                for (int j = 0; j < lastDiff; j++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            } else {
                for (int j = 0; j < firstDiff; j++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
