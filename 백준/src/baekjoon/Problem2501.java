package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2501
 */
public class Problem2501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = 0;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				count++;
			}

			if (count == K) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}
