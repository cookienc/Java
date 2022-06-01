package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1072
 */
public class Problem1072 {

	private static long X;
	private static long Y;
	private static long before;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		long low = 0;
		long high = 1_000_000_000;
		long mid = 0;
		long tmp = -1;
		before = Y * 100 / X;

		while (low <= high) {
			mid = low + ((high - low) / 2);

			if (isChangeable(mid)) {
				tmp = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(tmp);
	}

	private static boolean isChangeable(long mid) {
		long tmp = (Y + mid) * 100 / (X + mid);

		if (tmp == before) {
			return false;
		}

		return true;
	}
}
