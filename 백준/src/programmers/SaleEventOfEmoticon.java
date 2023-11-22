package programmers;

import java.util.ArrayList;
import java.util.List;

public class SaleEventOfEmoticon {

    public static void main(String[] args) {
        int[][] users = new int[][]{
                {40, 10000}, {25, 10000}
        };
        int[] emoticons = new int[]{7000, 9000};
        final Solution solution = new Solution();
        final int[] answer = solution.solution(users, emoticons);
        System.out.println(answer[0] + " " + answer[1]);
    }
    static class Solution {

        private static int[][] users;
        private static int[] emoticons;
        private static int[] answer = new int[2];
        private static int[] rates = new int[]{10, 20, 30, 40};
        /**
         * [목표]
         * 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것. -> 최우선
         * 이모티콘 판매액을 최대한 늘리는 것.
         *
         * [구매방식]
         * 1. 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
         * 2. 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
         */
        public int[] solution(int[][] users, int[] emoticons) {
            Solution.emoticons = emoticons;
            Solution.users = users;

            permutation(new ArrayList<>(), 0);

            return answer;
        }

        private void permutation(final List<Integer> discounts, final int depth) {
            if (depth == emoticons.length) {
                int sum = 0;
                int signPlus = 0;
                for (final int[] user : users) {
                    final int targetRate = user[0];
                    final int targetSum = user[1];

                    int userSum = 0;
                    for (int i = 0; i < emoticons.length; i++) {
                        final Integer discountRate = discounts.get(i);
                        if (discountRate >= targetRate) {
                            userSum += emoticons[i] - (int) (emoticons[i] * ((double) discountRate / 100));
                        }
                    }

                    if (userSum >= targetSum) {
                        userSum = 0;
                        signPlus++;
                    }
                    sum += userSum;
                }

                if (answer[0] == signPlus) {
                    answer[1] = Math.max(answer[1], sum);
                    return;
                }

                if (answer[0] < signPlus) {
                    answer[0] = signPlus;
                    answer[1] = sum;
                    return;
                }

                return;
            }

            for (int i = 0; i < 4; i++) {
                final List<Integer> clones = new ArrayList<>(discounts);
                clones.add(rates[i]);
                permutation(clones, depth + 1);
            }
        }
    }
}
