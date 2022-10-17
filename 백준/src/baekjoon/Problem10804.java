package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10804
 */
public class Problem10804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[21];

		for (int i = 1; i <= 20; i++) {
			arr[i] = i;
		}
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int[] tmp = new int[end - start + 1];
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = arr[end - j];
			}

			for (int j = 0; j < tmp.length; j++) {
				arr[j + start] = tmp[j];
			}
		}

		for (int i = 1; i <= 20; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
