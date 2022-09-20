package programmers;

/**
 * 출처: https://school.programmers.co.kr/learn/courses/30/lessons/72413
 */
public class TaxiFare {
	static class solution {
		private static int[][] map;
		private static int n;
		private static int s;
		private static int a;
		private static int b;
		private static int inf = 200 * 100_000 + 1;
		private static int answer = Integer.MAX_VALUE;

		public int solution(int n, int s, int a, int b, int[][] fares) {

			n = n;
			s = s - 1;
			a = a - 1;
			b = b - 1;

			map = new int[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (r == c) {
						map[r][c] = 0;
						continue;
					}
					map[r][c] = inf;
				}
			}

			for (int[] fare : fares) {
				int u = fare[0] - 1;
				int v = fare[1] - 1;
				int w = fare[2];

				map[u][v] = w;
				map[v][u] = w;
			}

			for (int k = 0; k < n; k++) {
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						map[r][c] = Math.min(map[r][c], map[r][k] + map[k][c]);
					}
				}
			}

			answer = Math.min(map[s][a] + map[a][b], map[s][b] + map[b][a]);
			answer = Math.min(answer, map[s][a] + map[s][b]);
			for (int i = 0; i < n; i++) {
				if (i == s) {
					continue;
				}
				answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
			}

			return answer;
		}
	}
}
