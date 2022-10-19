package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/10996
 */
public class Problem10996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < N; j++) {
					if (j % 2 == 0) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				sb.append("\n");
				continue;
			}
			for (int j = 0; j < N; j++) {
				if (j % 2 == 1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
