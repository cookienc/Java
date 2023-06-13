package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 출처: https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class PickTwoAndAddThem {
    static class Solution {

        private static boolean[] isVisited;
        private static Set<Integer> answers;
        private static int[] choice;

        public int[] solution(int[] numbers) {
            int size = numbers.length;
            isVisited = new boolean[size];
            answers = new HashSet<>();
            choice = new int[2];

            combination(numbers, 0, 0);
            return answers.stream()
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
        }

        private void combination(int[] numbers, int start, int depth) {
            if (depth == 2) {
                int sum = choice[0] + choice[1];
                answers.add(sum);
                return;
            }

            for (int i = 0; i < numbers.length; i++) {
                if (isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                choice[depth] = numbers[i];
                combination(numbers, i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
