package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1343
 */
public class Problem1343 {
	private static int cnt = 0;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'X') {
				cnt++;
				continue;
			}

			checkCnt();
			sb.append(".");
		}

		checkCnt();
		System.out.println(sb);
	}

	private static void checkCnt() {
		while (cnt >= 4) {
			cnt -= 4;
			sb.append("AAAA");
		}

		while (cnt >= 2) {
			cnt -= 2;
			sb.append("BB");
		}

		if (cnt != 0) {
			System.out.println(-1);
			System.exit(0);
		}
	}
}
