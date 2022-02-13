package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 출처: https://www.acmicpc.net/problem/2920
 */
public class Problem2920 {

	private static boolean isAscending;
	private static boolean isDescending;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";

		String S = bf.readLine();

		if (ascending.equals(S)) {
			isAscending = true;
		}

		if (descending.equals(S)) {
			isDescending = true;
		}

		if (isAscending) {
			System.out.println("ascending");
		} else if (isDescending) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
