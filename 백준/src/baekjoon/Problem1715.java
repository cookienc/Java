package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 출처: https://www.acmicpc.net/problem/1715
 */
public class Problem1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

		while (N-- > 0) {
			queue.add(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while (queue.size() != 1) {
			int num = queue.poll() + queue.poll();
			sum += num;
			queue.add(num);
		}

		System.out.println(sum);
	}
}
