package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10025
 */
public class Problem10025 {

	public static final int MAX_SIZE = 1_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ice = new int[MAX_SIZE];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ice[x] = g;
		}

		int low = 0;
		int high = 2 * K + 1;

		if (high >= MAX_SIZE) {
			high = MAX_SIZE - 1;
		}
		int sum = 0;
		for (int i = low; i < high; i++) {
			sum += ice[i];
		}

		int max = sum;

		while (high < MAX_SIZE) {
			sum -= ice[low++];
			sum += ice[high++];

			if (sum > max) {
				max = sum;
			}
		}

		System.out.println(max);
	}
}
