package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2470
 */
public class Problem2470 {

	private static int min = Integer.MAX_VALUE;
	private static int[] arr;
	private static final StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int low = 0;
		int high = N - 1;
		int sum = arr[low] + arr[high];
		check(sum, low, high);

		while (low < high) {
			sum = arr[low] + arr[high];
			check(sum, low, high);
			if (sum > 0) {
				high--;
			} else {
				low++;
			}
		}
		System.out.println(sb);
	}

	private static void check(int sum, int low, int high) {
		if (Math.abs(min) > Math.abs(sum)) {
			sb.setLength(0);
			min = Math.abs(sum);
			sb.append(arr[low]).append(" ").append(arr[high]);
		}
	}

}