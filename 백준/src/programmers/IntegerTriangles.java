package programmers;

/**
 * 출처: https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
 */
public class IntegerTriangles {
    static class Solution {

        public int solution(int[][] triangles) {

            int max = 0;
            int height = triangles.length;

            for (int r = 0; r < height; r++) {
                if (r == 0) {
                    continue;
                }

                int edge = triangles[r].length;
                for (int c = 0; c < edge; c++) {
                    if (c == 0) {
                        triangles[r][c] += triangles[r - 1][0];
                        continue;
                    }

                    if (c == edge - 1) {
                        triangles[r][c] += triangles[r - 1][triangles[r - 1].length - 1];
                        continue;
                    }

                    triangles[r][c] += Math.max(triangles[r - 1][c - 1], triangles[r - 1][c]);
                }

                if (r != height - 1) {
                    continue;
                }

                for (int c = 0; c < edge; c++) {
                    max = Math.max(max, triangles[r][c]);
                }
            }

            return max;
        }
    }
}
