package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1759
 */
public class Problem1759 {

	private static char[] arr;
	private static char[] answer;
	private static boolean[] isVisited;
	private static int L;
	private static int C;

	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		answer = new char[L];
		isVisited = new boolean[C];

		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int depth, int start) {

		if (depth == L) {

			int consonant = 0;
			int vowel = 0;
			for (char c : answer) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}

			if (vowel < 1 || consonant < 2) {
				return;
			}

			for (char c : answer) {
				sb.append(c);
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			answer[depth] = arr[i];
			combination(depth + 1, i + 1);
			isVisited[i] = false;
		}
	}
}
