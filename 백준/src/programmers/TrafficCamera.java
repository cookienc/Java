package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class TrafficCamera {

    static class Solution {

        public static void main(String[] args) {
            int[][] routes = new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
            System.out.println(solution(routes));
        }

        public static int solution(int[][] routes) {
            Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));

            final Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < routes.length; i++) {
                if (i == 0) {
                    stack.push(routes[i]);
                    continue;
                }

                if (!stack.isEmpty()) {
                    final int[] top = stack.peek();
                    final int[] cur = routes[i];
                    if (top[1] >= cur[0]) {
                        continue;
                    }
                    stack.push(cur);
                }
            }

            return stack.size();
        }
    }
}
