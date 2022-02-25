package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1389
 */
public class Problem1389 {

	private static List<List<Integer>> map;
	private static int[] count;
	private static boolean[] isVisited;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		count = new int[M + 1];

		map = new ArrayList<>();
		for (int i = 0; i <= M; i++) {
			map.add(new ArrayList<>());
		}

		while (N-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.get(from).add(to);
			map.get(to).add(from);
		}

		for (int i = 1; i <= M; i++) {
			isVisited = new boolean[M + 1];
			bfs(i);
		}

		int index = 1;
		int min = count[1];

		for (int i = 2; i <= M; i++) {
			if (min > count[i]) {
				index = i;
				min = count[i];
			}
		}
		System.out.println(index);
	}

	private static void bfs(int num) {
		isVisited[num] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{num, 0});

		while (!queue.isEmpty()){
			int value = queue.peek()[0];
			int distance = queue.peek()[1];
			queue.poll();

			List<Integer> friend = map.get(value);
			for (Integer name : friend) {
				if (!isVisited[name]) {
					isVisited[name] = true;
					count[num] += distance;
					queue.add(new int[]{name, distance + 1});
				}
			}
		}
	}
}
