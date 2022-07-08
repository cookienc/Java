package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * 출처: https://www.acmicpc.net/problem/16916
 */
public class Problem16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		String regex = ".*" + P + ".*";
		boolean matches = S.matches(regex);
		if (matches) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
