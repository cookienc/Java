package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressedAsN {
    static class Solution {
        private static List<Set<Integer>> dp;

        public int solution(int N, int number) {
            dp = new ArrayList<>();

            for (int i = 0; i < 9; i++) {
                dp.add(new HashSet<>());
            }

            dp.get(1).add(N);

            presentN(N);

            return find(number);
        }

        private static void presentN(final int N) {
            for (int i = 2; i < 9; i++) {
                final Set<Integer> currents = dp.get(i);

                for (int j = 1; j <= i; j++) {
                    final Set<Integer> from = dp.get(j);
                    final Set<Integer> to = dp.get(i - j);

                    for (final Integer f : from) {
                        for (final Integer t : to) {
                            currents.add(f + t);
                            currents.add(f - t);
                            currents.add(f * t);
                            if (t != 0) {
                                currents.add(f / t);
                            }
                        }
                    }
                }

                currents.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
        }

        private static int find(final int number) {
            for (final Set<Integer> d : dp) {
                if (d.contains(number)) {
                    return dp.indexOf(d);
                }
            }

            return -1;
        }
    }
}
