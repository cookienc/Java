package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1110
 */
public class Problem1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int answer = -1;
		if (arr.length > 1) {
			answer = (arr[0] - '0') * 10 + (arr[1] - '0');
		} else {
			answer = arr[0] - '0';
			arr = new char[2];
			arr[0] = Character.forDigit(0, 10);
			arr[1] = Character.forDigit(answer, 10);
		}

		int sum = -1;
		int cnt = 0;
		while (answer != sum) {
			cnt++;
			int tmp = sum(arr[0], arr[1]);

			if (tmp < 10) {
				arr[0] = arr[1];
				arr[1] = Character.forDigit(tmp, 10);
			} else {
				arr[0] = arr[1];
				arr[1] = String.valueOf(tmp).charAt(1);
			}
			sum = (arr[0] - '0') * 10 + (arr[1] - '0');
		}

		System.out.println(cnt);
	}

	private static int sum(char a, char b) {
		return (a - '0') + (b - '0');
	}
}
