package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/6416
 */
public class Problem6416 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> vertex = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = 0;
		while (true) {
			tc++;
			map = new HashMap<>();
			vertex = new HashSet<>();
			boolean flag = false;
			int a = -2;
			int b = -2;

			st = new StringTokenizer(br.readLine());
			while (true) {
				if (!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if (a == 0) {
					break;
				}

				if (a == -1) {
					break;
				}

				if (!vertex.add(b)) {
					flag = true;
				}

				map.merge(a, 0, Integer::sum);
			}

			if (vertex.size() != 0) {
				int rootNum = 0;
				for (int num : map.keySet()) {
					if (!vertex.contains(num)) {
						rootNum++;
					}
				}

				if (rootNum != 1) flag = true;
			}

			if (a == -1 && b == -1) {
				break;
			}

			if (flag) {
				sb.append("Case " + tc + " is not a tree.\n");
			} else {
				sb.append("Case " + tc + " is a tree.\n");
			}
		}

		System.out.println(sb);
	}
}
