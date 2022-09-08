package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14675
 */
public class Problem14675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] edges = new int[N + 1];
		Set<Integer> froms = new HashSet<>();
		Set<Integer> tos = new HashSet<>();

		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges[from]++;
			edges[to]++;
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			switch (type) {
				case 1: {
					if (edges[num] >= 2) {
						sb.append("yes").append("\n");
						break;
					}

					sb.append("no").append("\n");
					break;
				}

				case 2: {
					sb.append("yes").append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}
}
