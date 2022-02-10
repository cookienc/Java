package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2475
 */
public class Problem2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int sum = 0;

		for (int i = 0; i < 5; i++) {
			sum += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		sum %= 10;

		System.out.println(sum);
	}
}
