package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 출처: https://www.acmicpc.net/problem/21939
 */
public class Problem21939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		TreeSet<Problem> tree = new TreeSet<>();
		Map<Integer, Integer> problems = new HashMap<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			tree.add(new Problem(num, level));
			problems.put(num, level);
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			String command = st.nextToken();
			switch (command) {
				case "recommend":
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						Problem problem = tree.pollLast();
						sb.append(problem.number);
						tree.add(problem);
					} else {
						Problem problem = tree.pollFirst();
						sb.append(problem.number);
						tree.add(problem);
					}
					sb.append("\n");
					break;

				case "add":
					int num = Integer.parseInt(st.nextToken());
					int level = Integer.parseInt(st.nextToken());

					tree.add(new Problem(num, level));
					problems.put(num, level);
					break;

				case "solved":
					int P = Integer.parseInt(st.nextToken());
					Integer lev = problems.get(P);

					problems.remove(P);
					tree.remove(new Problem(P, lev));
					break;
			}
		}
		System.out.println(sb);
	}

	private static class Problem implements Comparable<Problem>{
		int number;
		int level;

		public Problem(int number, int level) {
			this.number = number;
			this.level = level;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.level - o.level == 0) {
				return this.number - o.number;
			} else {
				return this.level - o.level;
			}
		}
	}
}
