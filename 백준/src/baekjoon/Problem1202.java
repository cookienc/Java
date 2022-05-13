package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1202
 */
public class Problem1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Gem> gems = new PriorityQueue<>((g1, g2) -> g1.weight - g2.weight);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			gems.offer(new Gem(m, v));
		}

		Integer[] bag = new Integer[K];
		for (int i = 0; i < K; i++) {
			int bagSize = Integer.parseInt(br.readLine());
			bag[i] = bagSize;
		}

		Arrays.sort(bag);

		PriorityQueue<Gem> check = new PriorityQueue<>((g1, g2) -> g2.price - g1.price);
		long sum = 0;

		for (int i = 0; i < K; i++) {
			Integer bagSize = bag[i];

			for (int j = 0; j < N; j++) {
				if (gems.peek() == null || bagSize < gems.peek().weight) {
					break;
				}

				Gem gem = gems.poll();
				check.add(gem);
			}

			if (!check.isEmpty()) {
				sum += check.poll().price;
			}
		}

		System.out.println(sum);
	}

	public static class Gem {
		int weight;
		int price;

		public Gem(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
}
