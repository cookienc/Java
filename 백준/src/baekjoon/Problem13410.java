package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13410
 */
public class Problem13410 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> dan = new ArrayList<>();
		int start = N;
		for (int i = 1; i <= K; i++) {
			int sum = start * i;

			int length = String.valueOf(sum).length();
			int cnt = 0;
			int value = 0;
			while (sum > 0) {
				cnt++;
				int rest = sum % 10;
				value += rest * Math.pow(10, length - cnt);
				sum = sum / 10;
			}

			dan.add(value);
		}

		dan.sort(Comparator.reverseOrder());
		System.out.println(dan.get(0));
	}
}
