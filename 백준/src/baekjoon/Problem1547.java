package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1547
 */
public class Problem1547 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			list.add(i);
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cup1 = Integer.parseInt(st.nextToken()) - 1;
			int cup2 = Integer.parseInt(st.nextToken()) - 1;

			Collections.swap(list, list.indexOf(cup1), list.indexOf(cup2));
		}

		System.out.println(list.get(0) + 1);
	}
}
