package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2224
 */
public class Problem2224 {

	public static final int INF = 53;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int[][] arr = new int[52][52];

		for (int r = 0; r < 52; r++) {
			for (int c = 0; c < 52; c++) {
				if (r == c) {
					arr[r][c] = 0;
					continue;
				}
				arr[r][c] = INF;
			}
		}

		for (int i = 0; i < X; i++) {
			String[] s = br.readLine().split(" => ");
			int r = getInt(s[0]);
			int c = getInt(s[1]);
			if (r == c) {
				continue;
			}
			arr[r][c] = 1;
		}

		for (int i = 0; i < 52; i++) {
			for (int r = 0; r < 52; r++) {
				for (int c = 0; c < 52; c++) {
					arr[r][c] = Math.min(arr[r][i] + arr[i][c], arr[r][c]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int r = 0; r < 52; r++) {
			for (int c = 0; c < 52; c++) {
				if (arr[r][c] != INF && arr[r][c] != 0) {
					int nr = r;
					if (0 <= nr && nr < 26) {
						nr += 'A';
					} else {
						nr += 'a' - 26;
					}

					int nc = c;
					if (0 <= nc && nc < 26) {
						nc += 'A';
					} else {
						nc += 'a' - 26;
					}

					cnt++;
					sb.append((char) nr).append(" => ").append((char) nc).append("\n");
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static int getInt(String s) {
		int r = s.charAt(0);
		if ('A' <= r && r <= 'Z') {
			r = r - 'A';
		} else {
			r = r - 'a' + 26;
		}
		return r;
	}
}