package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem17127 {

    private static int N;
    private static int[] arr;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(final int idx, final int visited) {
        if (idx == N || Integer.bitCount(visited) >= N) {
            return;
        }

        if (Integer.bitCount(visited) == 3) {
            final List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                if ((visited & (1 << i)) != 0) {
                    tmp.add(i);
                }
            }
            final Integer zero = tmp.get(0);
            final Integer first = tmp.get(1);
            final Integer second = tmp.get(2);

            int zeroTmp = 1;
            for (int i = 0; i < zero; i++) {
                zeroTmp *= arr[i];
            }
            int firstTmp = 1;
            for (int i = zero; i < first; i++) {
                firstTmp *= arr[i];
            }
            int secondTmp = 1;
            for (int i = first; i < second; i++) {
                secondTmp *= arr[i];
            }

            int thirdTmp = 1;
            for (int i = second; i < N; i++) {
                thirdTmp *= arr[i];
            }

            max = Math.max(max, zeroTmp + firstTmp + secondTmp + thirdTmp);
            return;
        }

        for (int i = idx; i <= N - 1; i++) {
            dfs(i + 1, visited | (1 << (i + 1)));
        }
    }
}
