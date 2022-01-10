package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bufferedReader.readLine());
		int sum = 0;

		for (int i = 1; i < num; i++) {
			String word = String.valueOf(i);

			sum = i;

			for (int j = 0; j < word.length(); j++) {
				sum += word.charAt(j) - '0';
			}

			if (sum == num) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
	}
}
