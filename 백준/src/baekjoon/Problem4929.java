package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem4929 {

    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            final int M = Integer.parseInt(st.nextToken());
            int[] b = new int[M];
            for (int i = 0; i < M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            final List<Pair> pairs = getPairs(a, b);
            if (pairs.isEmpty()) {
                System.out.println(Math.max(Arrays.stream(a).sum(), Arrays.stream(b).sum()));
                continue;
            }

            final List<Integer> sameIndexOfAs = pairs.stream()
                    .map(pair -> pair.sameIndexOfA)
                    .collect(Collectors.toList());
            final List<Long> intervalSumOfA = getIntervalSum(a, sameIndexOfAs);

            final List<Integer> sameIndexOfBs = pairs.stream()
                    .map(pair -> pair.sameIndexOfB)
                    .collect(Collectors.toList());
            final List<Long> intervalSumOfB = getIntervalSum(b, sameIndexOfBs);

            final int min = Math.min(intervalSumOfA.size(), intervalSumOfB.size());

            int sum = 0;
            for (int i = 0; i < min; i++) {
                sum += Math.max(intervalSumOfA.get(i), intervalSumOfB.get(i));
            }

            if (intervalSumOfA.size() > intervalSumOfB.size()) {
                sum += intervalSumOfA.get(intervalSumOfA.size() - 1);
            } else if (intervalSumOfA.size() < intervalSumOfB.size()){
                sum += intervalSumOfB.get(intervalSumOfB.size() - 1);
            }
            System.out.println(sum);
        }
    }

    private static List<Pair> getPairs(final int[] a, final int[] b) {
        final List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            final int cur = a[i];
            for (int j = 0; j < b.length; j++) {
                final int target = b[j];
                if (cur == target) {
                    pairs.add(new Pair(i, j));
                    break;
                }
            }
        }

        return pairs;
    }

    private static List<Long> getIntervalSum(final int[] target, final List<Integer> sameIndexs) {

        final List<Long> internalSum = new ArrayList<>();

        int beforeIndex = -1;
        int s;
        for (s = 0; s < sameIndexs.size(); s++) {
            long sum = 0;
            final Integer sameIndex = sameIndexs.get(s);
            for (int i = beforeIndex + 1; i < target.length; i++) {
                sum += target[i];

                if (i == sameIndex) {
                    beforeIndex = sameIndex;
                    break;
                }
            }

            internalSum.add(sum);
        }

        final Integer startIndex = sameIndexs.get(sameIndexs.size() - 1);
        if (startIndex != target.length) {
            long sum = 0;
            for (int i = startIndex + 1; i < target.length; i++) {
                sum += target[i];
            }
            internalSum.add(sum);
        }
        return internalSum;
    }

    private static class Pair {
        int sameIndexOfA;
        int sameIndexOfB;

        public Pair(final int sameIndexOfA, final int sameIndexOfB) {
            this.sameIndexOfA = sameIndexOfA;
            this.sameIndexOfB = sameIndexOfB;
        }
    }
}
