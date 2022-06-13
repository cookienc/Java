package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1100
 */
public class Problem1100 {

	public static final int BOARD_SIZE = 8;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		for (int r = 0; r < BOARD_SIZE; r++) {
			char[] ch = br.readLine().toCharArray();

			if (r % 2 == 0) {
				for (int c = 0; c < BOARD_SIZE; c += 2) {
					if (ch[c] == 'F') {
						cnt++;
					}
				}
				continue;
			}

			for (int c = 1; c < BOARD_SIZE; c += 2) {
				if (ch[c] == 'F') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
