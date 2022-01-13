package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1065
 */
public class Problem1065 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		if (N == 1000) {
			System.out.println(getAnswer(999));
			System.exit(0);
		}
		System.out.println(getAnswer(N));
	}

	private static int getAnswer(int num) {
		int count = num;

		if (num >= 100) {
			count = 99;
			for (int i = 100; i <= num; i++) {
				String s = String.valueOf(i);

				int firstNo = s.charAt(0) - '0';
				int secondNo = s.charAt(1) - '0';
				int thirdNo = s.charAt(2) - '0';

				if (isNotAnswer(firstNo, secondNo, thirdNo)) {
					continue;
				}

				count++;
			}
		}

		return count;
	}

	private static boolean isNotAnswer(double firstNo, double secondNo, double thirdNo) {
		return secondNo != ((firstNo + thirdNo) / 2);
	}
}
