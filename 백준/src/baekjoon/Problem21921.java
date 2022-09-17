package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/21921
 */
public class Problem21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int max = 0;

		int start = 0;
		int end = 0;
		int sum = arr[0];

		while (start <= end) {
			while (end - start < X) {
				sum += arr[++end];
			}

			if (sum == max) {
				cnt++;
			}

			if (sum > max) {
				max = sum;
				cnt = 1;
			}

			sum -= arr[start++];
			if (end < N - 1) {
				sum += arr[++end];
			} else {
				break;
			}
		}


		if (max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(cnt);
	}
}
