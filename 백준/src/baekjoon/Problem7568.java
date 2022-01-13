package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/7568
 */
public class Problem7568 {

	private static int[][] array;
	private static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		array = new int[N][2];
		rank = new int[N];

		StringTokenizer stringTokenizer;
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			array[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			array[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}

				if ((array[i][0] < array[j][0]) && (array[i][1] < array[j][1])) {
					count++;
				}
			}
			rank[i] = count;
		}

		for (int i : rank) {
			System.out.print(i + " ");
		}


	}
}
