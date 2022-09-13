package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1092
 */
public class Problem1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		crane.sort(Comparator.reverseOrder());
		box.sort(Comparator.reverseOrder());

		if (box.get(0) > crane.get(0)) {
			System.out.println(-1);
			return;
		}

		int day = 0;

		while (!box.isEmpty()) {
			day++;
			for (Integer curCrane : crane) {
				for (int i = 0; i < box.size(); i++) {
					if (curCrane >= box.get(i)) {
						box.remove(i);
						break;
					}
				}
			}
		}
		System.out.println(day);
	}
}
