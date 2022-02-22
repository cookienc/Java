package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/2606
 */
public class Problem2606 {

	private static List<Integer>[] com;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		com = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			com[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			com[a].add(b);
			com[b].add(a);
		}

		System.out.println(bfs(1));
	}

	private static int bfs(int n) {
		if (isVisited[n]) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<>();
		isVisited[n] = true;
		queue.offer(n);
		int count = 0;

		while (!queue.isEmpty()) {
			Integer value = queue.poll();

			for (int i = 0; i < com[value].size(); i++) {
				Integer num = com[value].get(i);
				if (isVisited[num]) {
					continue;
				}
				isVisited[num] = true;
				count++;
				queue.offer(num);
			}
		}
		return count;
	}
}
