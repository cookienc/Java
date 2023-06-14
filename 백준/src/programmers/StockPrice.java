package programmers;

import java.util.Stack;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
    static class Solution {

        private static int[] answers;

        public int[] solution(int[] prices) {
            int length = prices.length;
            answers = new int[length];

            Stack<Integer> stack = new Stack<>();
            int idx = 0;

            stack.push(idx);
            for (idx = 1; idx < length; idx++) {
                while (!stack.isEmpty() && prices[idx] < prices[stack.peek()]) {
                    int targetIdx = stack.pop();
                    answers[targetIdx] = idx - targetIdx;
                }

                stack.push(idx);
            }

            while (!stack.isEmpty()) {
                int target = stack.pop();
                answers[target] = length - target - 1;
            }

            return answers;
        }
    }
}
