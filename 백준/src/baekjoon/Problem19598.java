package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/19598
 */
public class Problem19598 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Meeting> reservation = new PriorityQueue<>();
		PriorityQueue<Meeting> using = new PriorityQueue<>(Comparator.comparingInt(m -> m.end));

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			reservation.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int room = 1;
		while (!reservation.isEmpty()) {
			Meeting cur = reservation.poll();
			if (using.isEmpty()) {
				using.offer(cur);
			} else {
				if (using.peek().end <= cur.start) {
					using.poll();
					using.offer(cur);
				} else {
					using.add(cur);
					room++;
				}
			}
		}
		System.out.println(room);
	}

	private static class Meeting implements Comparable {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Object o) {
			Meeting m = (Meeting) o;
			if (start == m.start) {
				return end - m.end;
			}
			return start - m.start;
		}
	}
}
