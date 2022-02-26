package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/5525
 */
public class Problem5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		char[] words = bf.readLine().toCharArray();
		int[] count = new int[M];

		findContinuity(M, words, count);

		int answer = findAnswer(N, M, count);

		System.out.println(answer);
	}

	private static int findAnswer(int N, int M, int[] count) {
		int answer = 0;
		for (int i = 0; i < M; i++) {
			if (count[i] >= N) {
				answer++;
			}
		}
		return answer;
	}

	private static void findContinuity(int M, char[] words, int[] count) {

		for (int i = 0; i < M; i++) {
			if (words[i] == 'I') {

				for (int j = i + 1; j < M - 1; j++) {

					if (words[j] == 'O' && words[j + 1] == 'I') {
						count[j + 1] = count[j - 1] + 1;
						j++;
						continue;
					}
					i = j - 1;
					break;
				}
			}
		}
	}
}
