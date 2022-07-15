package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/14226
 */
public class Problem14226 {

	private static int[] arr;
	private static boolean[][] isVisited;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		isVisited = new boolean[1001][1001];
		bfs(S);

		System.out.println(answer);
	}

	private static void bfs(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>(comparingInt(n -> n.time));

		isVisited[0][0] = true;
		isVisited[1][0] = true;
		pq.add(new Node(1, 0, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curV = cur.value;
			int curT = cur.time;
			int curBoard = cur.clipboard;

			if (curV == s) {
				answer = curT;
				break;
			}

			// 하나빼기
			if (curV > 1 && !isVisited[curV - 1][curBoard]) {
				isVisited[curV - 1][curBoard] = true;
				pq.add(new Node(curV - 1, curBoard, curT + 1));
			}

			if (curV + curBoard > 1000) {
				continue;
			}

			// 클립보드에 저장
			if (!isVisited[curV][curV]) {
				isVisited[curV][curV] = true;
				pq.add(new Node(curV, curV, curT + 1));
			}

			// 붙여넣기
			if (curBoard != 0 && !isVisited[curV + curBoard][curBoard]) {
				isVisited[curV + curBoard][curBoard] = true;
				pq.add(new Node(curV + curBoard, curBoard, curT + 1));
			}
		}
	}


	private static class Node {
		int value;
		int clipboard;
		int time;

		public Node(int value, int clipboard, int time) {
			this.value = value;
			this.clipboard = clipboard;
			this.time = time;
		}
	}
}
