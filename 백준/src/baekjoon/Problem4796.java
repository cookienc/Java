package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4796
 */
public class Problem4796 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";
	public static final String COLON = ": ";
	public static final String CASE = "Case ";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int count = 0;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0) {
				break;
			}

			count++;
			int sum = V / P * L;
			int rest = V % P;
			if (rest > L) {
				sum += L;
			} else {
				sum += rest;
			}

			sb.append(CASE).append(count).append(COLON).append(sum).append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
