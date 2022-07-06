package baekjoon;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3460
 */
public class Problem3460 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			int count = 0;
			while (num > 1) {
				int rest = num % 2;
				if (rest == 1) {
					sb.append(count).append(" ");
				}
				count++;
				num /= 2;
			}

			if (num == 1) {
				sb.append(count).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
