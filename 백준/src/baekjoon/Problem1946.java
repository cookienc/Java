package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1946
 */
public class Problem1946 {

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			Score[] score = new Score[N];
			boolean[] checked = new boolean[N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(score, (s1, s2) -> s1.first - s2.first);

			Score flag = score[0];
			checked[0] = true;
			for (int i = 1; i < N; i++) {

				if (checked[i]) {
					break;
				}
				Score compare = score[i];

				if (flag.second > compare.second) {
					checked[i] = true;
					flag = score[i];
				}
			}

			int count = 0;
			for (boolean b : checked) {
				if (b) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static class Score {
		int first;
		int second;

		public Score(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}

