package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2775
 */
public class Problem2775 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[][] apartment = new int[15][15];
		for (int i = 1; i < 15; i++) {
			apartment[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				for (int k = 1; k <= j; k++) {
					apartment[i][j] += apartment[i - 1][k];
				}
			}
		}

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());
			sb.append(apartment[k][n])
					.append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
