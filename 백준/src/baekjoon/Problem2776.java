package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2776
 */
public class Problem2776 {

	private static Integer[] note1;
	private static Integer[] note2;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			initializeNote(br);
			for (Integer num : note2) {
				if (isRight(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static boolean isRight(Integer num) {

		int low = -1;
		int high = note1.length;

		while (low + 1 < high) {
			int mid = low + (high - low) / 2;

			if (note1[mid] >= num) {
				high = mid;
			} else {
				low = mid;
			}
		}

		if (high < note1.length && note1[high].equals(num)) {
			return true;
		}

		return false;
	}

	private static void initializeNote(BufferedReader br) throws IOException {
		//note1
		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			set.add(n);
		}

		note1 = set.stream()
				.sorted()
				.toArray(Integer[]::new);
		//note2
		int M = Integer.parseInt(br.readLine());
		note2 = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			note2[i] = Integer.parseInt(st.nextToken());
		}
	}
}
