package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1541
 * 참고: https://st-lab.tistory.com/148?category=882064
 */
public class Problem1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		boolean isFirstElement = true;

		StringTokenizer subtraction = new StringTokenizer(bufferedReader.readLine(), "-");
		StringTokenizer addition;

		while (subtraction.hasMoreTokens()) {
			int temp = 0;

			addition = new StringTokenizer(subtraction.nextToken(), "+");

			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}

			if (isFirstElement) {
				sum = temp;
				isFirstElement = false;
				continue;
			}

			sum -= temp;
		}

		System.out.println(sum);
	}
}
