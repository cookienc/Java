package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14238
 */
public class Problem14238 {

	private static String[][][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] member = br.readLine().toCharArray();

		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 0; i < member.length; i++) {
			switch (member[i]) {
				case 'A':
					a++;
					break;
				case 'B':
					b++;
					break;
				case 'C':
					c++;
					break;
			}
		}

		dp = new String[a + 1][b + 1][c + 1][4][4];
		solve(a, b, c, "", 'D', 'D');
		System.out.println(-1);
	}

	private static void solve(int a, int b, int c, String str, char before, char bBefore) {
		if (a == 0 && b == 0 && c == 0) {
			System.out.println(str);
			System.exit(0);
		}

		if (dp[a][b][c][before - 'A'][bBefore - 'A'] != null) {
			return;
		}
		dp[a][b][c][before - 'A'][bBefore - 'A'] = str;

		if (a > 0) {
			solve(a - 1, b, c, str + 'A', 'A', before);
		}

		if (b > 0 && before != 'B') {
			solve(a, b - 1, c, str + 'B', 'B', before);
		}

		if (c > 0 && before != 'C' && bBefore != 'C') {
			solve(a, b, c - 1, str + 'C', 'C', before);
		}
	}
}
