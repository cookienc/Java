package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 참조: https://www.acmicpc.net/problem/1931
 */
public class Problem1931 {

	private static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[][] time = new int[n][2];

		StringTokenizer stringTokenizer;
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			time[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			time[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(time, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		int value = time[0][1];

		for (int i = 1; i < n; i++) {
			if (value > time[i][0]) {
				continue;
			}
			count++;
			value = time[i][1];
		}
		System.out.println(count);
	}
}
