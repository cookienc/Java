package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13305
 * 참고: https://st-lab.tistory.com/192?category=882064
 */
public class Problem13305 {

	private static long[] price;
	private static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());

		price = new long[n];
		distance = new long[n - 1];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Long.parseLong(stringTokenizer.nextToken());
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			price[i] = Long.parseLong(stringTokenizer.nextToken());
		}

		long total = 0;
		long minPrice = price[0];

		for (int i = 0; i < n - 1; i++) {

			minPrice = Math.min(minPrice, price[i]);
			total += distance[i] * minPrice;
		}

		System.out.println(total);
	}
}
