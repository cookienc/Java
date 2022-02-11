package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1546
 */
public class Problem1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int sum = 0;
		int max = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			sum += score;
			max = Math.max(max, score);
		}
		System.out.println(sum / (double) max / N * 100);
	}
}
