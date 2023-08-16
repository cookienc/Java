package programmers;

import java.util.Arrays;
import java.util.Stack;

public class InterceptorsSystem {
    static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            Arrays.sort(targets, (a, b) -> a[1] - b[1]);

            Stack<Integer> stack = new Stack<>();
            for (int[] target : targets) {
                if (stack.isEmpty()) {
                    answer++;
                    stack.push(target[0]);
                    stack.push(target[1]);
                    continue;
                }

                if (target[0] >= stack.peek()) {
                    answer++;
                    stack.push(target[0]);
                    stack.push(target[1]);
                    continue;
                }

                if (target[1] < stack.peek()) {
                    continue;
                }
            }

            return answer;
        }
    }
}
