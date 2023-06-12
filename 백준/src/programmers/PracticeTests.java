package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTests {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution.solution(answers)));
    }

    static class Solution {

        private static final int[] ONE = {1, 2, 3, 4, 5};
        private static final int[] TWO = {2, 1, 2, 3, 2, 4, 2, 5};
        private static final int[] THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        public int[] solution(int[] answers) {

            int answerOne = 0;
            int oneSize = ONE.length;
            int answerTwo = 0;
            int twoSize = TWO.length;
            int answerThree = 0;
            int threeSize = THREE.length;

            for (int i = 0; i < answers.length; i++) {
                answerOne += match(answers, ONE, oneSize, i);
                answerTwo += match(answers, TWO, twoSize, i);
                answerThree += match(answers, THREE, threeSize, i);
            }

            int max = Math.max(answerOne, Math.max(answerTwo, answerThree));

            final List<Integer> names = findMax(answerOne, answerTwo, answerThree, max);
            int[] answer = new int[names.size()];
            int idx = 0;
            for (Integer name : names) {
                answer[idx++] = name;
            }

            return answer;
        }

        private static List<Integer> findMax(final int answerOne, final int answerTwo, final int answerThree, final int max) {
            final List<Integer> list = new ArrayList<>();
            if (answerOne == max) {
                list.add(1);
            }

            if (answerTwo == max) {
                list.add(2);
            }

            if (answerThree == max) {
                list.add(3);
            }

            return list;
        }

        private static int match(final int[] answers, final int[] target, final int size, final int index) {
            int currentOneIndex = index % size;
            if (target[currentOneIndex] == answers[index]) {
                return 1;
            }
            return 0;
        }
    }
}
