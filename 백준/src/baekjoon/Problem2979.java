package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2979
 */
public class Problem2979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j < end; j++) {
				arr[j]++;
			}
		}

		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 1; i <= 100; i++) {
			switch (arr[i]) {
				case 0:
					break;
				case 1:
					a++;
					break;
				case 2:
					b++;
					break;
				case 3:
					c++;
					break;
			}
		}

		System.out.println(a * A + b * 2 * B + c * 3 * C);
	}
}
