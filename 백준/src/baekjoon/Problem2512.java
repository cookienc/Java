package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2512
 */
public class Problem2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] asset = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			asset[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(asset);
		int M = Integer.parseInt(br.readLine());

		int low = 0;
		int high = asset[N - 1];
		while (low <= high) {

			int mid = (low + high) / 2;
			long budget = 0;
			for (int i = 0; i < N; i++) {
				if (asset[i] > mid) {
					budget += mid;
				} else {
					budget += asset[i];
				}
			}

			if (budget <= M) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(high);
	}
}
