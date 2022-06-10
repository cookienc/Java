package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * 출처: https://www.acmicpc.net/problem/1013
 */
public class Problem1013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			String str = br.readLine();
			String regex = "^(100+1+|01)+$";
			boolean matches = Pattern.matches(regex, str);

			if (matches) {
				sb.append("YES");
				sb.append("\n");
			} else {
				sb.append("NO");
				sb.append("\n");
			}

		}

		System.out.println(sb);
	}
}
