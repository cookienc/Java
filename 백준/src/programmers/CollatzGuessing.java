package programmers;

public class CollatzGuessing {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.solution(6));
    }

    static class Solution {
        public int solution(int num) {
            int cnt = 0;
            long lnum = (long) num;
            while (cnt <= 500 && lnum != 1) {
                if (lnum % 2 == 0) {
                    lnum /= 2;
                    cnt++;
                    continue;
                }

                lnum = 3 * lnum + 1;
                cnt++;
            }

            return cnt > 500 ?
                    -1 :
                    cnt;
        }
    }
}
