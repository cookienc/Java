package programmers;

import java.util.Arrays;

public class StudyingCodingTest {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int alp = 0;
        int cop = 0;
        int[][] problems = new int[][]{
                {0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}};
//        int alp = 10;
//        int cop = 10;
//        int[][] problems = new int[][]{
//                {10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}
//        };

        System.out.println(solution.solution(alp, cop, problems));
    }

    static class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            int[][] dp = new int[200][200];
            for (final int[] d : dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }

            int maxAlp = 0;
            int maxCop = 0;
            for (final int[] problem : problems) {
                final int requestAlp = problem[0];
                final int requestCop = problem[1];
                maxAlp = Math.max(requestAlp, maxAlp);
                maxCop = Math.max(requestCop, maxCop);
            }

            if (alp >= maxAlp && cop >= maxCop) {
                return 0;
            }

            if (alp >= maxAlp) {
                maxAlp = alp;
            }

            if (cop >= maxCop) {
                maxCop = cop;
            }

            dp[alp][cop] = 0;

            for (int i = alp; i < 151; i++) {
                for (int j = cop; j < 151; j++) {
                    dp[i + 1][j] = Math.min(dp[i][j] + 1, dp[i + 1][j]);
                    dp[i][j + 1] = Math.min(dp[i][j] + 1, dp[i][j + 1]);

                    for (final int[] problem : problems) {
                        final int requestAlp = problem[0];
                        final int requestCop = problem[1];
                        final int rewardAlp = problem[2];
                        final int rewardCop = problem[3];
                        final int time = problem[4];

                        if (i >= requestAlp && j >= requestCop) {
                            if (i + rewardAlp > maxAlp && j + rewardCop > maxCop) {
                                dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + time);
                                continue;
                            }

                            if (i + rewardAlp > maxAlp) {
                                dp[maxAlp][j + rewardCop] = Math.min(dp[maxAlp][j + rewardCop], dp[i][j] + time);
                                continue;
                            }

                            if (j + rewardCop > maxCop) {
                                dp[i + rewardAlp][maxCop] = Math.min(dp[i + rewardAlp][maxCop], dp[i][j] + time);
                                continue;
                            }

                            dp[i + rewardAlp][j + rewardCop] = Math.min(dp[i + rewardAlp][j + rewardCop], dp[i][j] + time);
                        }
                    }
                }
            }

            int max = 0;
            for (final int[] problem : problems) {
                max = Math.max(max, dp[problem[0]][problem[1]]);
            }
            return max;
        }
    }
}
