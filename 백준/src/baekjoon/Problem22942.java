package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/22942
 */
public class Problem22942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean flag = true;
		PriorityQueue<Line> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.left));
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int left = x - r;
			int right = x + r;

			pq.add(new Line(left, right));
		}

		Line cur = pq.poll();
		while (!pq.isEmpty()) {
			Line next = pq.poll();

			if (cur.left < next.left && next.left < cur.right) {
				if (next.right < cur.right) {
					cur = next;
					continue;
				}
			}

			if (cur.right < next.left) {
				cur = next;
				continue;
			}

			flag = false;
			cur = next;
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static class Line {
		int left;
		int right;

		public Line(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}
