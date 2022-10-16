package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10103
 */
public class Problem10103 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 100;
		int b = 100;

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == B) {
				continue;
			}

			if (A < B) {
				a -= B;
				continue;
			}

			b -= A;
		}
		System.out.println(a);
		System.out.println(b);
	}
}
