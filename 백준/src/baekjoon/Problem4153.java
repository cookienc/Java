package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4153
 */
public class Problem4153 {

	private static int[] array = new int[3];
	private static final StringBuilder stringBuilder = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(bf.readLine());

			array[0] = Integer.parseInt(st.nextToken());
			array[1] = Integer.parseInt(st.nextToken());
			array[2] = Integer.parseInt(st.nextToken());

			Arrays.sort(array);

			if (isItEnd(array[0], array[1], array[2])) {
				break;
			}

			isRightTriangle(array[0], array[1], array[2]);
		}

		System.out.println(stringBuilder);
	}

	private static void isRightTriangle(int A, int B, int C) {
		if (Math.pow(C, 2) == Math.pow(B, 2) + Math.pow(A, 2)) {
			stringBuilder.append("right");
		} else {
			stringBuilder.append("wrong");
		}
		stringBuilder.append(NEW_LINE);
	}

	private static boolean isItEnd(int A, int B, int C) {
		return A == 0 && B == 0 && C == 0;
	}
}
