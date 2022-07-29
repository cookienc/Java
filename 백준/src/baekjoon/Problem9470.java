package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/9470
 */
public class Problem9470 {

	private static int[][] count;
	private static List<List<Integer>> list;
	private static int[] vertex;
	private static int K;
	private static int M;
	private static int P;
	private static int answer;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			initialize(br);

			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				if (vertex[i] == 0) {
					q.add(i);
					count[i][1] = 1;
				}
			}

			while (!q.isEmpty()) {
				Integer cur = q.poll();
				int strahler = getStrahler(count[cur]);
				answer = Math.max(answer, strahler);

				for (Integer i : list.get(cur)) {
					vertex[i]--;
					count[i][strahler]++;

					if (vertex[i] == 0) {
						q.add(i);
					}
				}
			}

			sb.append(K).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static int getStrahler(int[] arr) {
		int strahler = -1;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 0) {
				continue;
			}
			strahler = i;
			break;
		}

		if (arr[strahler] >= 2) {
			strahler++;
			arr[strahler] = 1;
		}

		return strahler;
	}

	private static void initialize(BufferedReader br) throws IOException {
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			list.add(new ArrayList<>());
		}

		count = new int[M][M];
		vertex = new int[M];

		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			list.get(from).add(to);
			vertex[to]++;
		}
	}
}
