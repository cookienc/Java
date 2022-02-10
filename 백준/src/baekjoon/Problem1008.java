package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1008
 */
public class Problem1008 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		Double A = Double.parseDouble(st.nextToken());
		Double B = Double.parseDouble(st.nextToken());

		System.out.println(A / B);
	}
}
