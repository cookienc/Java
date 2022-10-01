package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4344
 */
public class Problem4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}

			Arrays.sort(arr);
			double average = sum / N;

			int cnt = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (average < arr[i]) {
					cnt++;
					continue;
				}
				break;
			}

			System.out.print(String.format("%.3f", (float) cnt / N * 100));
			System.out.println("%");
		}
	}
}
