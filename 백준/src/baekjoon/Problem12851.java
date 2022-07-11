package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/12851
 */
public class Problem12851 {

	private static int[] position;
	private static int N;
	private static int K;
	private static int answer = Integer.MAX_VALUE;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		position = new int[100_001];

		bfs();
		System.out.println(answer);
		System.out.println(count);
	}

	private static void bfs() {

		Arrays.fill(position, 100_001);

		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.count));
		q.add(new Node(N, 0));
		position[N] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int curX = cur.x;
			int curCount = cur.count;

			if (curCount > position[K]) {
				continue;
			}

			if (curX == K) {
				if (curCount < position[K]) {
					position[K] = curCount;
					answer = curCount;
					count = 1;
				} else if (curCount == position[K]) {
					position[K] = curCount;
					answer = curCount;
					count++;
				}
				continue;
			}

			position[curX] = curCount;

			int before = curX - 1;
			int after = curX + 1;
			int jump = curX * 2;

			if (before >= 0) {
				if (position[before] > curCount + 1) {
					q.add(new Node(before, curCount + 1));
				}
			}

			if (after <= 100_000) {
				if (position[after] > curCount + 1) {
					q.add(new Node(after, curCount + 1));
				}
			}

			if (jump <= 100_000) {
				if (position[jump] > curCount + 1) {
					q.add(new Node(jump, curCount + 1));
				}
			}
		}
	}

	private static class Node {
		int x;
		int count;

		public Node(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
}
