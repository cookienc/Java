package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 출처: https://www.acmicpc.net/problem/2164
 */
public class Problem2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		for (int i = 1; i < N; i++) {
			queue.poll();
			queue.add(queue.poll());
		}

		System.out.println(queue.peek());
	}
}
