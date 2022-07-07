package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1292
 */
public class Problem1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[1001];
		int k = 1;
		for (int i = 1; i <= 45; i++) {
			for (int j = 1; j <= i; j++) {
				if (k > 1000) {
					break;
				}
				arr[k++] = i;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int sum = 0;
		for (int i = A; i <= B; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}
}
