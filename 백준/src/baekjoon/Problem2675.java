package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2675
 */
public class Problem2675 {

	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();

			for (int j = 0; j < S.length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(S.charAt(j));
				}
			}

			sb.append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
