package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10869
 */
public class Problem10869 {

	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		sb.append(A + B)
				.append(NEW_LINE)
				.append(A - B)
				.append(NEW_LINE)
				.append(A * B)
				.append(NEW_LINE)
				.append(A / B)
				.append(NEW_LINE)
				.append(A % B)
				.append(NEW_LINE);

		System.out.println(sb);
	}
}
