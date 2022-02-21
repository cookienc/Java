package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1697
 */
public class Problem1697 {

	public static final int MAX_POSITOIN = 100_000;
	private static boolean[] isVisited = new boolean[100_001];
	private static int[] time = new int[100_001];
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bfs(N);

		System.out.println(time[M]);
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		isVisited[num] = true;
		queue.add(num);

		while (!queue.isEmpty()) {
			Integer position = queue.poll();

			if (position == M) {
				break;
			}

			verified(queue, position - 1, position);
			verified(queue, position + 1, position);
			verified(queue, position * 2, position);

		}
	}

	private static void verified(Queue<Integer> queue, int nextPosition, int currentPosition) {
		if (nextPosition < 0 || nextPosition > MAX_POSITOIN) {
			return;
		}

		if (isVisited[nextPosition]) {
			return;
		}

		isVisited[nextPosition] = true;
		queue.offer(nextPosition);
		time[nextPosition] = time[currentPosition] + 1;
	}
}
