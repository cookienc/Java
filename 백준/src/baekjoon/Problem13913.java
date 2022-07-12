package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/13913
 */
public class Problem13913 {
	static int N;
	static int K;
	static int[] parent = new int[100001];
	static int[] time = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		Stack<Integer> stack = new Stack<>();
		stack.push(K);

		int index = K;
		while (index != N) {
			stack.add(parent[index]);
			index = parent[index];
		}

		System.out.println(time[K]);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			if (cur == K) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				int next = -1;

				switch (i) {
					case 0:
						next = cur - 1;
						break;
					case 1:
						next = cur + 1;
						break;
					case 2:
						next = 2 * cur;
						break;
				}

				if (next < 0 || next > 100000) {
					continue;
				}

				if (time[next] == 0) {
					q.add(next);
					time[next] = time[cur] + 1;
					parent[next] = cur;
				}
			}
		}
	}
}