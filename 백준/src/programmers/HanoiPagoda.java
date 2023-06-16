package programmers;

import java.util.ArrayList;
import java.util.List;

public class HanoiPagoda {
    static class Solution {

        private static List<int[]> answers;

        public int[][] solution(int n) {
            answers = new ArrayList<>();
            find(n, 1, 2, 3);

            int[][] array = new int[answers.size()][2];
            for (int i = 0; i < answers.size(); i++) {
                array[i][0] = answers.get(i)[0];
                array[i][1] = answers.get(i)[1];
            }

            return array;
        }

        private static void find(int n, int start, int mid, int end) {
            if (n == 1) {
                answers.add(new int[]{start, end});
                return;
            }

            find(n - 1, start, end, mid);
            answers.add(new int[]{start, end});
            find(n - 1, mid, start, end);
        }
    }
}
