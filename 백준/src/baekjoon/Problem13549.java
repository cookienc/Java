package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13549
 */
public class Problem13549 {

	public static final int MAX_SIZE = 100_001;
	private static int[] position = new int[MAX_SIZE];
	private static boolean[] isVisited = new boolean[MAX_SIZE];
	private static int K;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}

		int time = 0;

		bfs(N, time);

		System.out.println(answer);
	}

	private static void bfs(int position, int time) {
		Queue<Node> queue = new LinkedList<>();

		isVisited[position] = true;
		queue.add(new Node(position, time));

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int currentPo = currentNode.position;
			int currentTi = currentNode.time;


			if (currentPo == K) {
				answer = Math.min(currentTi, answer);
			}

			if (currentPo * 2 < MAX_SIZE && !isVisited[currentPo * 2]) {
				isVisited[currentPo * 2] = true;
				queue.add(new Node(currentPo * 2, currentTi));
			}

			if (currentPo - 1 >= 0 && !isVisited[currentPo - 1]) {
				isVisited[currentPo - 1] = true;
				queue.add(new Node(currentPo - 1, currentTi + 1));
			}

			if (currentPo + 1 < MAX_SIZE && !isVisited[currentPo + 1]) {
				isVisited[currentPo + 1] = true;
				queue.add(new Node(currentPo + 1, currentTi + 1));
			}

		}
	}

	private static class Node {
		int position;
		int time;

		public Node(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}

}
