package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 출처: https://www.acmicpc.net/problem/21944
 */
public class Problem21944 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		TreeSet<Problem> ts = new TreeSet();
		Map<Integer, TreeSet<Problem>> categoryTree = new HashMap();
		Map<Integer, Integer> levelMap = new HashMap<>();
		Map<Integer, Integer> categoryMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			int category = Integer.parseInt(st.nextToken());
			ts.add(new Problem(number, level, category));
			if (categoryTree.containsKey(category)) {
				TreeSet<Problem> temp = categoryTree.get(category);
				temp.add(new Problem(number, level, category));
				categoryTree.replace(category, temp);
			} else {
				TreeSet<Problem> temp = new TreeSet<>();
				temp.add(new Problem(number, level, category));
				categoryTree.put(category, temp);
			}

			levelMap.put(number, level);
			categoryMap.put(number, category);
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "recommend": {
					int category = Integer.parseInt(st.nextToken());
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						sb.append(categoryTree.get(category).last().number).append("\n");
					} else {
						sb.append(categoryTree.get(category).first().number).append("\n");
					}
					break;
				}

				case "recommend2": {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						sb.append(ts.last().number).append("\n");
					} else {
						sb.append(ts.first().number).append("\n");
					}
					break;
				}

				case "recommend3": {
					int x = Integer.parseInt(st.nextToken());
					int level = Integer.parseInt(st.nextToken());
					if (x == 1) {
						if (ts.ceiling(new Problem(0, level, 0)) == null) {
							sb.append(-1).append("\n");
						} else {
							sb.append(ts.ceiling(new Problem(0, level, 0)).number).append("\n");
						}
					} else {
						if (ts.floor(new Problem(0, level, 0)) == null) {
							sb.append(-1).append("\n");
						} else {
							sb.append(ts.floor(new Problem(0, level, 0)).number).append("\n");
						}
					}
					break;
				}

				case "add": {
					int number = Integer.parseInt(st.nextToken());
					int level = Integer.parseInt(st.nextToken());
					int category = Integer.parseInt(st.nextToken());
					ts.add(new Problem(number, level, category));

					if (categoryTree.containsKey(category)) {
						TreeSet<Problem> temp = categoryTree.get(category);
						temp.add(new Problem(number, level, category));
						categoryTree.replace(category, temp);
					} else {
						TreeSet<Problem> temp = new TreeSet<>();
						temp.add(new Problem(number, level, category));
						categoryTree.put(category, temp);
					}

					levelMap.put(number, level);
					categoryMap.put(number, category);
					break;
				}

				case "solved": {
					int number = Integer.parseInt(st.nextToken());
					int level = levelMap.get(number);
					int category = categoryMap.get(number);
					ts.remove(new Problem(number, level, category));
					categoryTree.get(category).remove(new Problem(number, level, category));
					levelMap.remove(number);
					categoryMap.remove(number);
					break;
				}
			}
		}
		System.out.println(sb);
	}

	private static class Problem implements Comparable<Problem> {
		int number;
		int level;
		int category;

		public Problem(int number, int level, int category) {
			this.number = number;
			this.level = level;
			this.category = category;
		}

		public int compareTo(Problem o) {
			if (level - o.level == 0) {
				return number - o.number;
			} else {
				return level - o.level;
			}
		}
	}

}

