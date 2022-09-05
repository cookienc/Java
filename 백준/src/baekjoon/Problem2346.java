package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2346
 */
public class Problem2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Node> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			deque.add(new Node(i + 1, Integer.parseInt(st.nextToken())));
		}

		StringBuilder sb = new StringBuilder();
		sb.append(1).append(" ");
		int move = deque.pollFirst().val;

		while (!deque.isEmpty()) {
			Node cur = null;
			if (move > 0) {
				for (int i = 0; i < move - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
				cur = deque.pollFirst();
			} else {
				move = Math.abs(move);
				for (int i = 0; i < move - 1; i++) {
					deque.addFirst(deque.pollLast());
				}
				cur = deque.pollLast();
			}
			sb.append(cur.idx).append(" ");
			move = cur.val;
		}

		System.out.println(sb);
	}

	private static class Node {
		int idx;
		int val;

		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

}
