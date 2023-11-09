package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakeTwoQueuesEqualInSum {

    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            long sum1 = 0;
            int max1 = 0;
            final Queue<Integer> q1 = new ArrayDeque<>();
            for (final int i : queue1) {
                max1 = Math.max(max1, i);
                q1.add(i);
                sum1 += i;
            }

            long sum2 = 0;
            int max2 = 0;
            final Queue<Integer> q2 = new ArrayDeque<>();
            for (final int i : queue2) {
                max2 = Math.max(max2, i);
                q2.add(i);
                sum2 += i;
            }

            if ((sum1 + sum2) % 2 != 0) {
                return -1;
            }

            final int max = Math.max(max1, max2);

            if (sum1 + sum2 - max < max) {
                return -1;
            }

            int maxCnt = q1.size() + q2.size() + 100;
            int cnt = 0;
            while (sum1 != sum2 && cnt < maxCnt) {
                if (sum1 >= sum2) {
                    final Integer poll = q1.poll();
                    sum1 -= poll;
                    q2.offer(poll);
                    sum2 += poll;
                } else {
                    final Integer poll = q2.poll();
                    sum2 -= poll;
                    q1.offer(poll);
                    sum1 += poll;
                }

                cnt++;
            }

            return cnt >= maxCnt ? -1 : cnt;
        }
    }
}
