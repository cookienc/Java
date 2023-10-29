package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1421 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        final int W = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(trees);

        final int maxSize = trees[trees.length - 1];

        long max = Long.MIN_VALUE;
        for (int cutLength = 1; cutLength <= maxSize; cutLength++) {
            long sum = 0;
            for (final int t : trees) {
                final int curTree = t / cutLength;
                int cutCnt = 0;
                if (curTree != 0) {
                    if (t % cutLength == 0) {
                        cutCnt += curTree - 1;
                    } else {
                        cutCnt += curTree;
                    }
                }
                final long money = curTree * cutLength * W - cutCnt * C;
                if (money < 0) {
                    continue;
                }
                sum += money;
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
