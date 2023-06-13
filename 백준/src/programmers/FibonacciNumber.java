package programmers;

public class FibonacciNumber {
    static class Solution {

        private static int DIVIDE = 1234567;
        private static int[] FIBONACCI;

        public int solution(int n) {
            FIBONACCI = new int[n + 1];
            FIBONACCI[0] = 0;
            FIBONACCI[1] = 1;

            for(int i = 2; i <= n; i++) {
                FIBONACCI[i] += ((FIBONACCI[i - 1] % DIVIDE) + (FIBONACCI[i - 2] % DIVIDE)) % DIVIDE;
            }

            return FIBONACCI[n];
        }
    }
}
