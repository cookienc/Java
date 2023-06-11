package programmers;

import java.util.*;

/**
 * 출처: https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */
public class CreateStartAtTheIntersection {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[][] array = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, +1},
                {5, -8, -12},
                {5, 8, 12}
        };
        final String[] s = solution.solution(array);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    static class Solution {

        private static long MAX_VALUE = 100_000 * 100_000;

        public String[] solution(int[][] lines) {
            long maxLeft = MAX_VALUE;
            long maxRight = -MAX_VALUE;
            long maxDown = MAX_VALUE;
            long maxUp = -MAX_VALUE;

            Set<Intersection> intersections = new HashSet<>();

            for (int i = 0; i < lines.length; i++) {
                final int[] currentLine = lines[i];
                long A = (long) currentLine[0];
                long B = (long) currentLine[1];
                long E = (long) currentLine[2];

                for (int j = i + 1; j < lines.length; j++) {
                    final int[] nextLine = lines[j];
                    long C = (long) nextLine[0];
                    long D = (long) nextLine[1];
                    long F = (long) nextLine[2];

                    if (A * D == B * C) {
                        continue;
                    }

                    double x = (double) (B * F - E * D) / (double) (A * D - B * C);

                    if (x % 1 != 0.0) {
                        continue;
                    }

                    double y = (double) (E * C - A * F) / (double) (A * D - B * C);
                    if (y % 1 != 0.0) {
                        continue;
                    }

                    long ix = (long) x;
                    long iy = (long) y;

                    maxRight = Math.max(ix, maxRight);
                    maxLeft = Math.min(ix, maxLeft);
                    maxUp = Math.max(iy, maxUp);
                    maxDown = Math.min(iy, maxDown);

                    intersections.add(new Intersection(ix, iy));
                }
            }

            char[][] array = new char[(int) (maxUp - maxDown) + 1][(int) (maxRight - maxLeft) + 1];
            for (char[] chars : array) {
                Arrays.fill(chars, '.');
            }

            for (Intersection intersection : intersections) {
                array[(int) (maxUp - intersection.y)][(int) (intersection.x - maxLeft)] = '*';
            }

            List<String> answer = new ArrayList<>();
            for (char[] chars : array) {
                StringBuilder sb = new StringBuilder();
                for (char it : chars) {
                    sb.append(it);
                }
                answer.add(sb.toString());
            }
            return answer.toArray(String[]::new);
        }

        static class Intersection {
            long x;
            long y;

            public Intersection(final long x, final long y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(final Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                final Intersection that = (Intersection) o;
                return x == that.x && y == that.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}
