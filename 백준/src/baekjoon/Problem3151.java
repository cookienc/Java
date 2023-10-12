package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3151 {

    private static int[] members;

    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        members = new int[N];
        for (int i = 0; i < N; i++) {
            final int n = Integer.parseInt(st.nextToken());
            members[i] = n;
        }

        Arrays.sort(members);

        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = members[i] + members[j];
                final long lowerIdx = lowerBound(j, -sum);
                final long upperIdx = upperBound(j, -sum);
                if (upperIdx == members.length && lowerIdx == members.length) {
                    continue;
                }
                answer += upperIdx - lowerIdx;
            }
        }

        System.out.println(answer);
    }

    private static long lowerBound(final int start, final int target) {
        int lo = start;
        int hi = members.length;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (members[mid] >= target) {
                hi = mid;
                continue;
            }
            lo = mid;
        }

        return hi;
    }

    private static long upperBound(final int start, final int target) {
        int lo = start;
        int hi = members.length;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (members[mid] <= target) {
                lo = mid;
                continue;
            }
            hi = mid;
        }

        return hi;
    }

}
