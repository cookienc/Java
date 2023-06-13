package programmers;

public class Immigration {
    static class Solution {
        public long solution(int n, int[] times) {
            long start = 0;
            long end = (long) n * times[times.length - 1];

            while (start + 1 < end) {
                long mid = (end - start) / 2 + start;
                long people = calculatePeople(mid, times);

                if (people < n) {
                    start = mid;
                    continue;
                }

                end = mid;
            }

            return end;
        }

        private long calculatePeople(long currentTime, int[] times) {
            long people = 0;

            for (int t : times) {
                people += currentTime / t;

                if (people > 1_000_000_000) {
                    break;
                }
            }

            return people;
        }
    }
}
