package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15903
 */
public class Problem15903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>(Long::compare);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		long sum = 0;
		while (m-- > 0) {
			Long first = pq.poll();
			Long second = pq.poll();

			sum = first + second;

			pq.offer(sum);
			pq.offer(sum);
		}

		sum = 0;
		for (Long l : pq) {
			sum += l;
		}

		System.out.println(sum);
	}
}
