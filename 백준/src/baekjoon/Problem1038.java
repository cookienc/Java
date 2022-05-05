package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 출처: https://www.acmicpc.net/problem/1038
 */
public class Problem1038 {

	private static int N;
	private static List<Long> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if (N <= 9) {
			System.out.println(N);
			return;
		} else if (N >= 1023) {
			System.out.println(-1);
			return;
		}
		list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			find(i, 1);
		}
		Collections.sort(list);
		System.out.println(list.get(N));
	}

	private static void find(long num, int idx) {
		if (idx > 10) {
			return;
		}
		list.add(num);
		for (int i = 0; i < num % 10; i++) {
			find(num * 10 + i, idx + 1);
		}
	}
}
