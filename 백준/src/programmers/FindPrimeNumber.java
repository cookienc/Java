package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class FindPrimeNumber {

	static class Solution {
		private static int count = 0;
		private static int length;
		private static boolean[] isVisited;
		private static int[] array;
		private static int[] answer;
		private static StringBuilder sb;
		private static boolean[] prime;

		public int solution(String numbers) {
			prime = new boolean[10_000_000];
			makePrime(prime);
			length = numbers.length();
			array = new int[length];
			isVisited = new boolean[length];

			for (int i = 0; i < length; i++) {
				array[i] = Integer.valueOf(numbers.charAt(i) - '0');
			}

			for (int i = 1; i <= length; i++) {
				answer = new int[i];
				sb = new StringBuilder();
				perm(0, i);
			}

			return count;
		}

		private void perm(int i, int depth) {

			if (i == depth) {
				sb = new StringBuilder();
				for (int a : answer) {
					sb.append(a + "");
				}

				int idx = Integer.parseInt(sb.toString());
				if (prime[idx]) {
					count++;
					prime[idx] = false;
				}

				return;
			}

			for (int j = 0; j < length; j++) {
				if (isVisited[j]) {
					continue;
				}

				isVisited[j] = true;
				answer[i] = array[j];
				perm(i + 1, depth);
				isVisited[j] = false;
			}
		}

		private void makePrime(boolean[] prime) {
			Arrays.fill(prime, true);
			prime[0] = false;
			prime[1] = false;
			for (int i = 2; i * i < prime.length; i++) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
	}
}
