package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1259
 */
public class Problem1259 {

	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String num = bf.readLine();

		while (true) {
			boolean isSame = true;

			int length = num.length();
			for (int i = 0; i < length / 2; i++) {
				if (num.charAt(i) != num.charAt((length - 1) - i)) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append(NEW_LINE);

			num = bf.readLine();
			if (num.equals("0")) {
				break;
			}
		}

		System.out.println(sb);
	}
}
