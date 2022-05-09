package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		int[] number = new int[11];
		long total = 0;
		for (int i = 0; i < N.length(); i++) {
			int num = N.charAt(i) - '0';
			number[num]++;
			total += num;
		}

		if (total % 3 != 0 || number[0] == 0) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 10; i >= 0 ; i--) {
			if (number[i] == 0) {
				continue;
			}
			while (number[i]-- > 0) {
				sb.append(i);
			}

		}

		System.out.println(sb);
	}
}
