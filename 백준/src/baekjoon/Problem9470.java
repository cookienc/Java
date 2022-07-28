package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/9470
 */
public class Problem9470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			List<List<Integer>> info = new ArrayList<>();

			int[][] count = new int[M][M];
			int[] node = new int[M];

			for (int i = 0; i < M; i++) {
				info.add(new ArrayList<>());
			}

			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				info.get(from).add(to);
				node[to]++;
			}

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < M; i++) {
				if (node[i] != 0) {
					continue;
				}
				q.add(i);
				count[i][1] = 1;
			}

			int result = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				int curS = findMax(count[cur], M);
				if (count[cur][curS] >= 2) {
					curS++;
					count[cur][curS] = 1;
				}
				result = Math.max(curS, result);

				for (Integer index : info.get(cur)) {
					count[index][curS]++;
					node[index]--;
					if (node[index] == 0) {
						q.add(index);
					}
				}
			}
			System.out.println(K + " " + result);
		}
	}

	private static int findMax ( int[] arr, int m){
		int max = 0;
		for (int i = m - 1; i >= 0; i--) {
			if (arr[i] > 0) {
				max = i;
				break;
			}
		}
		return max;
	}
}
