package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10250
 */
public class Problem10250 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			String height = String.format("%d", N % H);
			String distance = String.format("%02d", N / H + 1);
			if (height.equals("0")) {
				height = String.valueOf(H);
				distance = String.format("%02d", N / H);
			}

			sb.append(height)
					.append(distance)
					.append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
